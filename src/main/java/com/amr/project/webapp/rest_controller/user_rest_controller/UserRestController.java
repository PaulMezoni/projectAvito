package com.amr.project.webapp.rest_controller.user_rest_controller;

import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopMapper;
import com.amr.project.model.dto.ItemDto;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.User;
import com.amr.project.service.abstracts.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.*;

@AllArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;

    private final ShopMapper shopMapper;

    private final ItemMapper itemMapper;


    @PostMapping("/registration")
    public ResponseEntity<?> registrationNewUser(@Valid @RequestBody User user) {
        Map<String, Object> body = new LinkedHashMap<>();
        User registratedUser = userService.findByEmail(user.getEmail());
        if (registratedUser != null) {
            body.put("isExist", "User with this email exist");
            return ResponseEntity.badRequest().body(body);
        }
        registratedUser = userService.findByPhone(user.getPhone());
        if (registratedUser != null) {
            body.put("isExist", "User with this phone exist");
            return ResponseEntity.badRequest().body(body);
        }
        registratedUser = userService.findByUsername(user.getUsername());
        if (registratedUser != null) {
            body.put("isExist", "User with this username exist");
            return ResponseEntity.badRequest().body(body);
        }
        userService.persist(user);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/getUserShops/{id}")
    public ResponseEntity<List<ShopDto>> getShops(@PathVariable("id") Long id) {
        User user = userService.getByKey(id);
        List<ShopDto> shops = new ArrayList<>();
        user.getShops().stream().forEach(shop -> shops.add(shopMapper.shopToDto(shop)));
        if (shops.size() < 1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(shops);

    }

    @GetMapping("/getUserOrders/{id}")
    public ResponseEntity<List<ItemDto>> getOrders(@PathVariable("id") Long id) {
        User user = userService.getByKey(id);
        List<ItemDto> itemDtos = new ArrayList<>();
        user.getOrders().stream().forEach(order -> order.getItems().stream().forEach(item -> itemDtos.add(itemMapper.itemToDto(item))));
        if (itemDtos.size() == 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(itemDtos);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<?> validationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        Map<String, Object> body = new LinkedHashMap<>();
        Map<String, String> errors = new HashMap<>();
        fieldErrors.forEach(f -> errors.put(f.getField(), f.getDefaultMessage()));
        body.put("errors", errors);
        return ResponseEntity.badRequest().body(body);
    }


}

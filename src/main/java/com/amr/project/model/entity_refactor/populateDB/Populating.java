package com.amr.project.model.entity_refactor.populateDB;

import com.amr.project.model.entity_refactor.*;
import com.amr.project.model.entity_refactor.populateDB.repository.*;
import com.amr.project.model.enums.Gender;
import com.amr.project.model.enums.Status;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class Populating {

    private CountryRepository countryRepository;
    private CityRepository cityRepository;
    private AddressRepository addressRepository;
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private ShopRepository shopRepository;
    private ImageRepository imageRepository;
    private CategoryRepository categoryRepository;
    private ItemRepository itemRepository;
    private ReviewShopRepository reviewShopRepository;
    private ReviewItemRepository reviewItemRepository;
    private DiscountRepository discountRepository;
    private OrderDetailsRepository orderDetailsRepository;
    private OrderRepository orderRepository;
    private CartItemRepository cartItemRepository;
    private CouponRepository couponRepository;
    private ChatRepository chatRepository;
    private MessageRepository messageRepository;

    @PostConstruct
    public void init() throws IOException {
        //--------------------------------------------------------------------------------------Countries
        Country russia = Country.builder().name("Russia").build();
        Country ukraine = Country.builder().name("Ukraine").build();
        Country belorus = Country.builder().name("Belorus").build();

        countryRepository.save(russia);
        countryRepository.save(ukraine);
        countryRepository.save(belorus);
        //--------------------------------------------------------------------------------------Cities
        City moscow = City.builder().name("Moscow").cityIndex("123456").country(russia).build();
        City petersburg = City.builder().name("Saint-Petersburg").cityIndex("123456").country(russia).build();
        City novosibirsk = City.builder().name("Novosibirsk").cityIndex("123456").country(russia).build();

        City kyiv = City.builder().name("Kyiv").cityIndex("123456").country(ukraine).build();
        City kharkiv = City.builder().name("Kharkiv").cityIndex("123456").country(ukraine).build();
        City odessa = City.builder().name("Odessa").cityIndex("123456").country(ukraine).build();

        City minsk = City.builder().name("Minsk").cityIndex("123456").country(belorus).build();
        City gomel = City.builder().name("Gomel").cityIndex("123456").country(belorus).build();
        City vitebsk = City.builder().name("Vitebsk").cityIndex("123456").country(belorus).build();

        cityRepository.save(moscow);
        cityRepository.save(petersburg);
        cityRepository.save(novosibirsk);

        cityRepository.save(kyiv);
        cityRepository.save(kharkiv);
        cityRepository.save(odessa);

        cityRepository.save(minsk);
        cityRepository.save(gomel);
        cityRepository.save(vitebsk);
        //--------------------------------------------------------------------------------------Addresses
        Address address1 = Address.builder()
                .country(russia)
                .city(moscow)
                .street("street1")
                .house("house1")
                .build();
        Address address2 = Address.builder()
                .country(ukraine)
                .city(kyiv)
                .street("street2")
                .house("house2")
                .build();
        Address address3 = Address.builder()
                .country(belorus)
                .city(minsk)
                .street("street3")
                .house("house3")
                .build();

        addressRepository.save(address1);
        addressRepository.save(address2);
        addressRepository.save(address3);
        //--------------------------------------------------------------------------------------Images
        File admin_image =  ResourceUtils.getFile("classpath:static/images/users/admin_image.jpg");
        File moderator_image =  ResourceUtils.getFile("classpath:static/images/users/moderator_image.jpg");

        File user1_image =  ResourceUtils.getFile("classpath:static/images/users/user1_image.jpg");
        File user2_image =  ResourceUtils.getFile("classpath:static/images/users/user2_image.jpg");
        File user3_image =  ResourceUtils.getFile("classpath:static/images/users/user3_image.jpg");
        File user4_image =  ResourceUtils.getFile("classpath:static/images/users/user4_image.jpg");
        File user5_image =  ResourceUtils.getFile("classpath:static/images/users/user5_image.jpg");
        File user6_image =  ResourceUtils.getFile("classpath:static/images/users/user6_image.jpg");

        File shop1_image =  ResourceUtils.getFile("classpath:static/images/shops/shop1_image.jpg");
        File shop2_image =  ResourceUtils.getFile("classpath:static/images/shops/shop2_image.jpg");
        File shop3_image =  ResourceUtils.getFile("classpath:static/images/shops/shop3_image.jpg");

        File item1_image1 =  ResourceUtils.getFile("classpath:static/images/items/item1_image1.jpg");
        File item1_image2 =  ResourceUtils.getFile("classpath:static/images/items/item1_image2.jpg");
        File item1_image3 =  ResourceUtils.getFile("classpath:static/images/items/item1_image3.jpg");

        File item2_image1 =  ResourceUtils.getFile("classpath:static/images/items/item2_image1.jpg");
        File item2_image2 =  ResourceUtils.getFile("classpath:static/images/items/item2_image2.jpg");
        File item2_image3 =  ResourceUtils.getFile("classpath:static/images/items/item2_image3.jpg");

        File item3_image1 =  ResourceUtils.getFile("classpath:static/images/items/item3_image1.jpg");
        File item3_image2 =  ResourceUtils.getFile("classpath:static/images/items/item3_image2.jpg");
        File item3_image3 =  ResourceUtils.getFile("classpath:static/images/items/item3_image3.jpg");

        byte[] array_admin_image = Files.readAllBytes(admin_image.toPath());
        byte[] array_moderator_image = Files.readAllBytes(moderator_image.toPath());
        byte[] array_user1_image = Files.readAllBytes(user1_image.toPath());
        byte[] array_user2_image = Files.readAllBytes(user2_image.toPath());
        byte[] array_user3_image = Files.readAllBytes(user3_image.toPath());

        byte[] array_shop1_image = Files.readAllBytes(shop1_image.toPath());
        byte[] array_shop2_image = Files.readAllBytes(shop2_image.toPath());
        byte[] array_shop3_image = Files.readAllBytes(shop3_image.toPath());

        byte[] array_item1_image1 = Files.readAllBytes(item1_image1.toPath());
        byte[] array_item1_image2 = Files.readAllBytes(item1_image2.toPath());
        byte[] array_item1_image3 = Files.readAllBytes(item1_image3.toPath());

        byte[] array_item2_image1 = Files.readAllBytes(item2_image1.toPath());
        byte[] array_item2_image2 = Files.readAllBytes(item2_image2.toPath());
        byte[] array_item2_image3 = Files.readAllBytes(item2_image3.toPath());

        byte[] array_item3_image1 = Files.readAllBytes(item3_image1.toPath());
        byte[] array_item3_image2 = Files.readAllBytes(item3_image2.toPath());
        byte[] array_item3_image3 = Files.readAllBytes(item3_image3.toPath());

        Image adminImage = Image.builder().picture(array_admin_image).isMain(true).build();
        Image moderatorImage = Image.builder().picture(array_moderator_image).isMain(true).build();
        Image user1Image = Image.builder().picture(array_user1_image).isMain(true).build();
        Image user2Image = Image.builder().picture(array_user2_image).isMain(true).build();
        Image user3Image = Image.builder().picture(array_user3_image).isMain(true).build();

        Image shop1Image = Image.builder().picture(array_shop1_image).isMain(true).build();
        Image shop2Image = Image.builder().picture(array_shop2_image).isMain(true).build();
        Image shop3Image = Image.builder().picture(array_shop3_image).isMain(true).build();

        Image item1Image1 = Image.builder().picture(array_item1_image1).isMain(true).build();
        Image item1Image2 = Image.builder().picture(array_item1_image2).isMain(false).build();
        Image item1Image3 = Image.builder().picture(array_item1_image3).isMain(false).build();

        Image item2Image1 = Image.builder().picture(array_item2_image1).isMain(true).build();
        Image item2Image2 = Image.builder().picture(array_item2_image2).isMain(false).build();
        Image item2Image3 = Image.builder().picture(array_item2_image3).isMain(false).build();

        Image item3Image1 = Image.builder().picture(array_item3_image1).isMain(true).build();
        Image item3Image2 = Image.builder().picture(array_item3_image2).isMain(false).build();
        Image item3Image3 = Image.builder().picture(array_item3_image3).isMain(false).build();

        imageRepository.save(user1Image);
        imageRepository.save(user2Image);
        imageRepository.save(user3Image);
        imageRepository.save(adminImage);
        imageRepository.save(moderatorImage);

        imageRepository.save(shop1Image);
        imageRepository.save(shop2Image);
        imageRepository.save(shop3Image);

        imageRepository.save(item1Image1);
        imageRepository.save(item1Image2);
        imageRepository.save(item1Image3);

        imageRepository.save(item2Image1);
        imageRepository.save(item2Image2);
        imageRepository.save(item2Image3);

        imageRepository.save(item3Image1);
        imageRepository.save(item3Image2);
        imageRepository.save(item3Image3);
        //--------------------------------------------------------------------------------------Roles
        Role roleAdmin = Role.builder().name("Admin").build();
        Role roleModerator = Role.builder().name("Moderator").build();
        Role roleUser = Role.builder().name("User").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleModerator);
        roleRepository.save(roleUser);
        //--------------------------------------------------------------------------------------Users
        User admin = User.builder()
                .email("admin@mail")
                .username("admin")
                .password("password")
                .activate(true)
                .activationCode(null)
                .phone(null)
                .firstName("admin")
                .lastName("admin")
                .age(0)
                .gender(null)
                .birthday(null)
                .images(adminImage)
                .roles(Set.of(roleAdmin, roleModerator, roleUser))
                .address(null)
                .build();

        User moderator = User.builder()
                .email("moderator@mail")
                .username("moderator")
                .password("password")
                .activate(true)
                .activationCode(null)
                .phone(null)
                .firstName("moderator")
                .lastName("moderator")
                .age(0)
                .gender(null)
                .birthday(null)
                .images(moderatorImage)
                .roles(Set.of(roleModerator))
                .address(null)
                .build();

        User user1 = User.builder()
                .email("user1@mail")
                .username("user1")
                .password("password")
                .activate(true)
                .activationCode("111111")
                .phone("111111")
                .firstName("user1")
                .lastName("user1")
                .age(21)
                .gender(Gender.MALE)
                .birthday(GregorianCalendar.getInstance())
                .images(user1Image)
                .roles(Set.of(roleUser))
                .address(List.of(address1))
                .build();

        User user2 = User.builder()
                .email("user2@mail")
                .username("user2")
                .password("password")
                .activate(true)
                .activationCode("222222")
                .phone("222222")
                .firstName("user2")
                .lastName("user2")
                .age(21)
                .gender(Gender.FEMALE)
                .birthday(GregorianCalendar.getInstance())
                .images(user2Image)
                .roles(Set.of(roleUser))
                .address(List.of(address1, address2))
                .build();

        User user3 = User.builder()
                .email("user3@mail")
                .username("user3")
                .password("password")
                .activate(true)
                .activationCode("333333")
                .phone("333333")
                .firstName("user3")
                .lastName("user3")
                .age(0)
                .gender(Gender.UNKNOWN)
                .birthday(GregorianCalendar.getInstance())
                .images(user3Image)
                .roles(List.of(roleUser))
                .address(List.of(address1, address2, address3))
                .build();

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(admin);
        userRepository.save(moderator);
        //--------------------------------------------------------------------------------------Shops
        Shop shop1 = Shop.builder()
                .name("shop1")
                .email("shop1@mail")
                .phone("111111")
                .description("descr shop1")
                .City(moscow)
                .image(shop1Image)
                .user(user1)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .activity(0)
                .build();
        Shop shop2 = Shop.builder()
                .name("shop2")
                .email("shop2@mail")
                .phone("111111")
                .description("descr shop2")
                .City(kyiv)
                .image(shop2Image)
                .user(user2)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .activity(0)
                .build();
        Shop shop3 = Shop.builder()
                .name("shop3")
                .email("shop3@mail")
                .phone("111111")
                .description("descr shop3")
                .City(minsk)
                .image(shop3Image)
                .user(user3)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .activity(0)
                .build();

        shopRepository.save(shop1);
        shopRepository.save(shop2);
        shopRepository.save(shop3);
        //--------------------------------------------------------------------------------------Categories
        Category category1 = Category.builder().name("category1").build();
        Category category2 = Category.builder().name("category2").build();
        Category category3 = Category.builder().name("category3").build();

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
        //--------------------------------------------------------------------------------------Items
        Item item1 = Item.builder()
                .name("item1")
                .price(new BigDecimal("111"))
                .count(111)
                .rating(0d)
                .description("descr item1")
                .categories(List.of(category1))
                .discount(0)
                .images(List.of(item1Image1, item1Image2, item1Image3))
                .shop(shop1)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .build();
        Item item2 = Item.builder()
                .name("item2")
                .price(new BigDecimal("222"))
                .count(222)
                .rating(0d)
                .description("descr item2")
                .categories(List.of(category1, category2))
                .discount(0)
                .images(List.of(item2Image1, item2Image2, item2Image3))
                .shop(shop2)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .build();
        Item item3 = Item.builder()
                .name("item3")
                .price(new BigDecimal("333"))
                .count(333)
                .rating(0d)
                .description("descr item3")
                .categories(List.of(category1, category2, category3))
                .discount(0)
                .images(List.of(item3Image1, item3Image2, item3Image3))
                .shop(shop3)
                .isModerated(false)
                .isModerateAccept(false)
                .isPretendentToBeDeleted(false)
                .moderatedRejectReason(null)
                .build();

        itemRepository.save(item1);
        itemRepository.save(item2);
        itemRepository.save(item3);
        //------------------------------------------------------------------------------------------------ReviewsShop
        ReviewShop reviewShop1 = ReviewShop.builder()
                .dignity("dignify1")
                .flaw("flaw1")
                .text("text1")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(1)
                .user(user1)
                .shop(shop1)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();
        ReviewShop reviewShop2 = ReviewShop.builder()
                .dignity("dignify2")
                .flaw("flaw2")
                .text("text2")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(2)
                .user(user1)
                .shop(shop2)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();
        ReviewShop reviewShop3 = ReviewShop.builder()
                .dignity("dignify3")
                .flaw("flaw3")
                .text("text3")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(3)
                .user(user2)
                .shop(shop1)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();

        reviewShopRepository.save(reviewShop1);
        reviewShopRepository.save(reviewShop2);
        reviewShopRepository.save(reviewShop3);
        //------------------------------------------------------------------------------------------------ReviewsItem
        ReviewItem reviewItem1 = ReviewItem.builder()
                .dignity("dignify1")
                .flaw("flaw1")
                .text("text1")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(1)
                .user(user1)
                .item(item1)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();
        ReviewItem reviewItem2 = ReviewItem.builder()
                .dignity("dignify2")
                .flaw("flaw2")
                .text("text2")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(2)
                .user(user1)
                .item(item2)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();
        ReviewItem reviewItem3 = ReviewItem.builder()
                .dignity("dignify3")
                .flaw("flaw3")
                .text("text3")
                .date(GregorianCalendar.getInstance().getTime())
                .rating(3)
                .user(user2)
                .item(item3)
                .isModerated(false)
                .isModerateAccept(false)
                .moderatedRejectReason("reason")
                .build();

        reviewItemRepository.save(reviewItem1);
        reviewItemRepository.save(reviewItem2);
        reviewItemRepository.save(reviewItem3);
        //------------------------------------------------------------------------------------------------Discount
        Discount discount1 = Discount.builder()
                .minOrder(1000)
                .percentage(10)
                .fixedDiscount(100)
                .shop(shop1)
                .user(user1)
                .build();
        Discount discount2 = Discount.builder()
                .minOrder(2000)
                .percentage(20)
                .fixedDiscount(200)
                .shop(shop2)
                .user(user2)
                .build();
        Discount discount3 = Discount.builder()
                .minOrder(3000)
                .percentage(30)
                .fixedDiscount(300)
                .shop(shop3)
                .user(user1)
                .build();

        discountRepository.save(discount1);
        discountRepository.save(discount2);
        discountRepository.save(discount3);
        //------------------------------------------------------------------------------------------------Orders
        OrderDetails orderDetails1 = OrderDetails.builder()
                .buyerName(user1.getUsername())
                .buyerPhone(user1.getPhone())
                .build();
        Order order1 = Order.builder()
                .date(GregorianCalendar.getInstance())
                .status(Status.START)
                .total(null)
                .items(List.of(item1, item2))
                .user(user1)
                .orderDetails(orderDetails1)
                .build();

        OrderDetails orderDetails2 = OrderDetails.builder()
                .buyerName(user2.getUsername())
                .buyerPhone(user2.getPhone())
                .build();
        Order order2 = Order.builder()
                .date(GregorianCalendar.getInstance())
                .status(Status.START)
                .total(null)
                .items(List.of(item2, item3))
                .user(user2)
                .orderDetails(orderDetails2)
                .build();

        orderDetailsRepository.save(orderDetails1);
        orderDetailsRepository.save(orderDetails2);
        orderRepository.save(order1);
        orderRepository.save(order2);
        //-----------------------------------------------------------------------------------------------Carts
        CartItem cartItem1 = CartItem.builder()
                .item(item1)
                .shop(item1.getShop())
                .quantity(10)
                .user(user1)
                .build();
        CartItem cartItem2 = CartItem.builder()
                .item(item2)
                .shop(item2.getShop())
                .quantity(20)
                .user(user1)
                .build();
        CartItem cartItem3 = CartItem.builder()
                .item(item3)
                .shop(item3.getShop())
                .quantity(30)
                .user(user3)
                .build();

        cartItemRepository.save(cartItem1);
        cartItemRepository.save(cartItem2);
        cartItemRepository.save(cartItem3);
        //-----------------------------------------------------------------------------------------------Coupons
        Coupon coupon1 = Coupon.builder().build();
        Coupon coupon2 = Coupon.builder().build();
        Coupon coupon3 = Coupon.builder().build();

        couponRepository.save(coupon1);
        couponRepository.save(coupon2);
        couponRepository.save(coupon3);

        user1.setCoupons(List.of(coupon1));
        user2.setCoupons(List.of(coupon1, coupon2));
        user3.setCoupons(List.of(coupon1, coupon2, coupon3));
        //------------------------------------------------------------------------------------------------Favorites
        user1.setFavoriteItems(List.of(item1));
        user2.setFavoriteItems(List.of(item1, item2));
        user3.setFavoriteShops(List.of(shop1, shop2));

        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        //------------------------------------------------------------------------------------------------Messages, Chats
        Chat chat1 = Chat.builder()
                .members(List.of(admin, moderator))
                .hash(123456L)
                .build();
        chatRepository.save(chat1);

        Message message1 = Message.builder()
                .from(admin)
                .to(moderator)
                .textMessage("text from admin to moderator")
                .chat(chat1)
                .build();
        Message message2 = Message.builder()
                .from(moderator)
                .to(admin)
                .textMessage("text from moderator to admin")
                .chat(chat1)
                .build();

        messageRepository.save(message1);
        messageRepository.save(message2);

        chat1.setMessages(List.of(message1, message2));
        chatRepository.save(chat1);
    }
}




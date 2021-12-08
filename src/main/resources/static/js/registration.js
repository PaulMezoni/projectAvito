const userService = {
    head: {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Referer': null
    },
    registerNewUser: async (user) => await fetch('/registration', {
        method: 'POST',
        headers: userService.head,
        body: JSON.stringify(user)
    }),
}
$(document).ready(function () {

    $('#registrationButtonModal').on('click', function () {
        $('#staticBackdrop').slideUp()
        $('.registrationForm').slideDown()
    })
    $('.btn-close').on('click', function () {
        $('.registrationForm').slideUp()
        $('#staticBackdrop').slideDown()
    })
    $('.registrationButton').on('click', async function (event) {
        let imageInput = $('.avatarImage')[0].files[0]
        let image
        if (imageInput !== undefined) {
            image = imageToBinary(imageInput)
        }
        let user = {
            email: $('.registrationForm .email').val(),
            username: $('.registrationForm .username').val(),
            password: $('.registrationForm .password').val(),
            phone: $('.registrationForm .phone').val(),
            firstName: $('.registrationForm .firstName').val(),
            lastName: $('.registrationForm .lastName').val(),
            gender: $('.registrationForm input[name="gender"]:checked').val(),
            age: $('.registrationForm .age').val(),
            birthday: $('.registrationForm .birthday').val(),
            images: {
                picture: image,
                isMain: true
            }
        }
        console.log(user)
        userVerification(user)
    })


})

//check user to exists in BD and validation user fields
async function userVerification(user) {
    $('.alert').hide("slide")
    let response = await userService.registerNewUser(user)
    if (response.ok) {
        $('#successfulRegistration').show('slide')
    } else {
        let responseBody = await response.json().then(result => result)
        console.log(responseBody)
        if (responseBody.isExist !== undefined) {
            let massage = responseBody.isExist;
            let alert = $('#isExistAlert')
            alert.empty()
            alert.append(massage)
            alert.show('slide')
        } else {
            responseBody = responseBody.errors
            for (let i in user) {
                let inputAlert = $('#' + i.toString() + 'Alert')
                if (responseBody[i] !== undefined) {
                    let alertMassage = `<small> ${responseBody[i]} </small>`
                    inputAlert.empty()
                    inputAlert.append(alertMassage)
                    inputAlert.show('slide')
                }
            }
        }
    }
}

// convert image to byte array
function imageToBinary(image) {
    let reader = new FileReader();
    reader.readAsDataURL(image);
    reader.onloadend = function () {
        let data = (reader.result).split(',')[1];
        let binaryBlob = atob(data);
        localStorage.setItem("image", binaryBlob)
    }
    let imageBase64 = localStorage.getItem("image")
    return base64ToBinary(imageBase64)
}

function base64ToBinary(imageBase64) {
    let bytes = [];
    for (let i = 0; i < imageBase64.length; i++) {
        bytes.push(
            imageBase64.charCodeAt(i)
        );
    }
    return bytes
}




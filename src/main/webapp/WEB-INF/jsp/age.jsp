<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 30.09.2018
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Age</title>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
</head>
<style>
    .wrapper-form{
        display: flex;
        flex-direction: column;
    }
</style>
<script>
    function onClickSubmit() {
        let birthday = $('#birthday').val();
        $.ajax({
            type: "POST",
            url: "/birthday",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            dataType: "json",
            data: birthday
        }).done(function(result) {
            alert(result);
        })
        .fail(function (result) {
            alert(result);
        })
    }
</script>
<body>
    <div class="wrapper-form">
        Введите дату рождения: <input type = "text"
                                      id="birthday"
                                      class="birthday-input"
                                      pattern="^(?:(?:31(\/|-)(?:0?[13578]|1[02]))\1|(?:(?:29|30)(\/|-)(?:0?[1,3-9]|1[0-2])\2))(?:(?:1[6-9]|[2-9]\d)?\d{2})$|^(?:29(\/|-)0?2\3(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\d|2[0-8])(\/|-)(?:(?:0?[1-9])|(?:1[0-2]))\4(?:(?:1[6-9]|[2-9]\d)?\d{2})$"
                                      name = "birthday">
        <button class="birthday-button" onclick="onClickSubmit()">Отправить</button>
    </div>
</body>
</html>

<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<div>
    <fieldset>
        <legend>Update</legend>
        <form name="item" action="" method="POST">
            Name:<@spring.formInput "form.name" "" "text"/>
            <br>
            Price:<@spring.formInput "form.price" "" "text"/>
            <br>
            Capacity:<@spring.formInput "form.capacity" "" "text"/>
            <br>
            Type:<@spring.formInput "form.type" "" "text"/>
            <br>
            Reservation:<@spring.formInput "form.reservation" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>
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
        <form name="record" action="" method="POST">
            Client:<@spring.formSingleSelect "form.client", clients, ""/>
            <br>
            Room:<@spring.formSingleSelect "form.room", rooms, ""/>
            <br>
            Start:<@spring.formInput "form.start" "" "date"/>
            <br>
            Finish:<@spring.formInput "form.finish" "" "date"/>
            <br>
            Description:<@spring.formInput "form.description" "" "text"/>
            <br>
            <input type="submit" value="Update"/>
        </form>
    </fieldset>
</div>

</body>
</html>
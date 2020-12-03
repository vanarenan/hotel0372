<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<a href="/index.html"  class="btn btn-danger">⇐</a><br>
<body>
<h3>Client List</h3>
<br>
<div>
    <a href="/web/client/create"  class="btn btn-warning">Create</a><br>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/client/list/sort/name'">Name </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/client/list/sort/passport'">Passport </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/client/list/sort/description'">Description </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/client/list/sort/created'">Created </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/client/list/sort/modified'">Modified </button></th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#--<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->
        </head>
        <body>

        <#list clients as element> <!--Цикл по всем element !! -->
            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.passport}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/client/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>
                <td><a href="/web/client/edit/${element.id}" class="btn btn-outline-success">Edit</a></td>
            </tr>

        </#list>
        </tbody>
    </table>

</div>
</body>
</html>
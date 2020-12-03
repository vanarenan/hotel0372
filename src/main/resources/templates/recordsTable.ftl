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

<h3>Record List</h3>
<br>
<#--<form name="Search" action="" method="post">
    Search:<@spring.formInput "search.name" "" "text"/>
    <input type="submit" value="Find"/>
    <br>
</form>-->
<br>
<div>
    <a href="/web/record/create"  class="btn btn-warning">Create</a>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/name'">Room </button></th>
            <th>Client</th>
           <#-- <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/description'">Description </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/start'">Start </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/finish'">Finish </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/created'">Created </button></th>
            <th><button class="btn btn-outline-light" onclick="window.location.href = '/web/record/list/sort/modified'">Modified </button></th>
          -->
            <th>Description</th>
            <th>Start</th>
            <th>Finish</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list records as element> <!--Цикл по всем element !! -->
            <!--Для каждого element в списке items , который мы получили
             из контроллера . -----------------------------
             Формируем строку <tr>. У этой строки есть ..5.. ячеек
              Каждая ичейка является полем ..елемента.. !
              (id)(name) т.д !!! -->
            <tr>
                <td>${element.id}</td>
                <td>${element.room.name}</td>
                <td>${element.client.name}</td>
                <td>${element.description}</td>
                <td>${element.start}</td>
                <td>${element.finish}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/record/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>
                <td><a href="/web/record/update/${element.id}" class="btn btn-outline-success">Edit</a></td>
            </tr>
        </#list>
        </tbody>
    </table>


</div>
</body>
</html>
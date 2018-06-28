

<h1>Listado de Areas</h1>
    <table class="table table-hover">
      <tr></tr>
      <tr class="active"></tr>
      <tr class="primary">...</tr>
      <tr class="success">...</tr>
      <tr class="warning">...</tr>
      <tr class="danger">...</tr>
      <tr class="info">...</tr>
      </table>
      <!-- En celdas (`td` or `th`) -->
      <table class="table table-hover">
      <tr>
        <td>...</td>
        <td class="active">...</td>
        <td class="primary">...</td>
        <td class="success">...</td>
        <td class="warning">...</td>
        <td class="danger">...</td>
        <td class="info">...</td>
      </tr>
      </table>
     
<#list model as post>
    <div class="post">
        <h2>${post.title}</h2>
        <p>${post.content}</p>   
        <i>Published on the ${post.publishing_date}</i>
    </div>
</#list>

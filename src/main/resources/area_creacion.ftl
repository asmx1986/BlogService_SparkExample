<h2>Crear Area!</h2>

<#list model as post>
    <div class="post">
        <h2>${post.title}</h2>
        <p>${post.content}</p>
        
 
        <i>Published on the ${post.publishing_date}</i>
    </div>
</#list>

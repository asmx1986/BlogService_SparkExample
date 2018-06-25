<h2>Listado!</h2>

<#list model as Area>
    <div class="area">
        <h2>${post.title}</h2>
        <p>${post.content}</p>
        
        <h3>Categories:</h3>
        <ul class="categories">
            <#list post.categories as category>
                <li>${category}</li>
            </#list>
        </ul>
        <i>Published on the ${post.publishing_date}</i>
    </div>
</#list>

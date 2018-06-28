<h2>Listado!</h2>

<#list model as unArea>
    <div class="area">
        <h2>Nombre: ${unArea.nombre}</h2>
        <h5>id: ${unArea.uuid}</h5>
        
        <h3>Motivos de Visita:</h3>
        <ul class="motivosVisita">
            <#list unArea.motivos as mv>
                <li>${mv}</li>
            </#list>
        </ul>
    </div>
    --------------
</#list>
<a href="/areas/create_form">Nuevo</a>
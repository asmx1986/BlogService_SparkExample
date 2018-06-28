<h2>Listado!</h2>

<form method="post" action="/areas" enctype="application/json">
	<input type="text" name="nombre" value="${model.nombre!''}" />

	<input type="submit" value="Crear" />
	<a href="/areas">Volver</a>
</form>
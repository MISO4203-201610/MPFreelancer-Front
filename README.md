#Tabla de contenidos
-  [Introducción](#introducción)
-  [API](#api-de-la-aplicación-mpfreelancer)
  - [Entidad Category](#entidad-category)
  - [Entidad Education](#entidad-education)
  - [Entidad Freelancer](#entidad-freelancer)
  - [Entidad Project](#entidad-project)
  - [Entidad ProjectSponsor](#entidad-projectsponsor)
  - [Entidad Skill](#entidad-skill)
  - [Entidad Status](#entidad-status)

#API Rest
##Introducción
La comunicación entre cliente y servidor se realiza intercambiando objetos JSON. Para cada entidad se hace un mapeo a JSON, donde cada uno de sus atributos se transforma en una propiedad de un objeto JSON. Todos los servicios se generan en la URL /MPFreelancer.api/webresources/. Por defecto, todas las entidades tienen un atributo `id`, con el cual se identifica cada registro:

```javascript
{
    id: '',
    attribute_1: '',
    attribute_2: '',
    ...
    attribute_n: ''
}
```

###CRUD Básico
Para los servicios de CRUD Básico, Cuando se transmite información sobre un registro específico, se realiza enviando un objeto con la estructura mencionada en la sección anterior.
La única excepción se presenta al solicitar al servidor una lista de los registros en la base de datos, que incluye información adicional para manejar paginación de lado del servidor.

La respuesta del servidor al solicitar una colección presenta el siguiente formato:

```javascript
{
    totalRecords: 0, //cantidad de registros en la base de datos
    records: [] //collección con los datos solicitados. cada objeto tiene la estructura de la entidad.
}
```

##API de la aplicación MPFreelancer
###Entidad Category
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Category, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Category
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/categorys|Obtener todos los objetos JSON de Category (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Category y el total de registros en la base de datos en el header X-Total-Count
**GET**|/categorys/:id|Obtener los atributos de una instancia de Category en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Category
**POST**|/categorys|Crear una nueva instancia de la entidad Category (CREATE)||Objeto JSON de Category a crear|Objeto JSON de Category creado
**PUT**|/categorys/:id|Actualiza una instancia de la entidad Category (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Category|Objeto JSON de Category actualizado
**DELETE**|/categorys/:id|Borra instancia de Category en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Category
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Category son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|categorys/:id/projects|Obtener instancias de projects(Project) asociados con Category|**@PathParam id**: `id` de instancia de Category||Colección de `id` de projects(Project) asociados con Category
**PUT**|categorys/:id/projects|Actualización de referencias a projects(Project) desde Category|**@PathParam id**: `id` de instancia de Category|Colección de `id` de projects(Project) a asociar|Colección de objetos JSON de projects(Project) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Education
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Education, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Education
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    startDate: '' /*Tipo Date*/,
    endDate: '' /*Tipo Date*/,
    institution: '' /*Tipo String*/,
    title: '' /*Tipo String*/,
    description: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/educations|Obtener todos los objetos JSON de Education (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Education y el total de registros en la base de datos en el header X-Total-Count
**GET**|/educations/:id|Obtener los atributos de una instancia de Education en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Education
**POST**|/educations|Crear una nueva instancia de la entidad Education (CREATE)||Objeto JSON de Education a crear|Objeto JSON de Education creado
**PUT**|/educations/:id|Actualiza una instancia de la entidad Education (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Education|Objeto JSON de Education actualizado
**DELETE**|/educations/:id|Borra instancia de Education en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

[Volver arriba](#tabla-de-contenidos)

###Entidad Freelancer
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Freelancer, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Freelancer
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    rate: '' /*Tipo Integer*/,
    bithday: '' /*Tipo Date*/,
    picture: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/freelancers|Obtener todos los objetos JSON de Freelancer (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Freelancer y el total de registros en la base de datos en el header X-Total-Count
**GET**|/freelancers/:id|Obtener los atributos de una instancia de Freelancer en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Freelancer
**POST**|/freelancers|Crear una nueva instancia de la entidad Freelancer (CREATE)||Objeto JSON de Freelancer a crear|Objeto JSON de Freelancer creado
**PUT**|/freelancers/:id|Actualiza una instancia de la entidad Freelancer (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Freelancer|Objeto JSON de Freelancer actualizado
**DELETE**|/freelancers/:id|Borra instancia de Freelancer en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Freelancer
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Freelancer son los siguientes:

######Relaciones Composite

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|freelancers/:id/titles|Obtener Objetos JSON de titles(Education) dependientes de Freelancer|**@PathParam id**: `id` de instancia de Freelancer||Colección de objetos JSON de titles(Education)
**POST**|freelancers/:id/titles|Creación de instancias de titles(Education) dependientes de Freelancer|**@PathParam id**: `id` de instancia de Freelancer|Colección de objetos JSON de titles(Education) a crear|Colección de objetos JSON de titles(Education) creados con sus respectivos ID
**PUT**|freelancers/:id/titles|Actualización de instancias de titles(Education) dependientes de Freelancer|**@PathParam id**: `id` de instancia de Freelancer|Colección de objetos JSON de titles(Education) a actualizar|Colección de objetos JSON de titles(Education) actualizados
**DELETE**|freelancers/:id/titles|Eliminación de instancias de titles(Education) dependientes de Freelancer|**@PathParam id**: `id` de instancia de Freelancer|Colección de atributo `id` de titles(Education) a eliminar|

######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|freelancers/:id/skills|Obtener instancias de skills(Skill) asociados con Freelancer|**@PathParam id**: `id` de instancia de Freelancer||Colección de `id` de skills(Skill) asociados con Freelancer
**PUT**|freelancers/:id/skills|Actualización de referencias a skills(Skill) desde Freelancer|**@PathParam id**: `id` de instancia de Freelancer|Colección de `id` de skills(Skill) a asociar|Colección de objetos JSON de skills(Skill) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Project
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Project, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Project
```javascript
{
    id: '' /*Tipo Long*/,
    price: '' /*Tipo Integer*/,
    deadLine: '' /*Tipo Date*/,
    status: '' /*Objeto que representa instancia de Status*/,
    name: '' /*Tipo String*/,
    category: '' /*Objeto que representa instancia de Category*/,
    sponsor: '' /*Objeto que representa instancia de ProjectSponsor*/,
    description: '' /*Tipo String*/,
    publicationDate: '' /*Tipo Date*/,
    startDate: '' /*Tipo Date*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/projects|Obtener todos los objetos JSON de Project (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Project y el total de registros en la base de datos en el header X-Total-Count
**GET**|/projects/:id|Obtener los atributos de una instancia de Project en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Project
**POST**|/projects|Crear una nueva instancia de la entidad Project (CREATE)||Objeto JSON de Project a crear|Objeto JSON de Project creado
**PUT**|/projects/:id|Actualiza una instancia de la entidad Project (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Project|Objeto JSON de Project actualizado
**DELETE**|/projects/:id|Borra instancia de Project en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Project
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Project son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|projects/:id/expectedskills|Obtener instancias de expectedskills(Skill) asociados con Project|**@PathParam id**: `id` de instancia de Project||Colección de `id` de expectedskills(Skill) asociados con Project
**PUT**|projects/:id/expectedskills|Actualización de referencias a expectedskills(Skill) desde Project|**@PathParam id**: `id` de instancia de Project|Colección de `id` de expectedskills(Skill) a asociar|Colección de objetos JSON de expectedskills(Skill) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad ProjectSponsor
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad ProjectSponsor, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto ProjectSponsor
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    company: '' /*Tipo String*/,
    picture: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/projectSponsors|Obtener todos los objetos JSON de ProjectSponsor (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON ProjectSponsor y el total de registros en la base de datos en el header X-Total-Count
**GET**|/projectSponsors/:id|Obtener los atributos de una instancia de ProjectSponsor en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de ProjectSponsor
**POST**|/projectSponsors|Crear una nueva instancia de la entidad ProjectSponsor (CREATE)||Objeto JSON de ProjectSponsor a crear|Objeto JSON de ProjectSponsor creado
**PUT**|/projectSponsors/:id|Actualiza una instancia de la entidad ProjectSponsor (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de ProjectSponsor|Objeto JSON de ProjectSponsor actualizado
**DELETE**|/projectSponsors/:id|Borra instancia de ProjectSponsor en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de ProjectSponsor
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de ProjectSponsor son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|projectSponsors/:id/projects|Obtener instancias de projects(Project) asociados con ProjectSponsor|**@PathParam id**: `id` de instancia de ProjectSponsor||Colección de `id` de projects(Project) asociados con ProjectSponsor
**PUT**|projectSponsors/:id/projects|Actualización de referencias a projects(Project) desde ProjectSponsor|**@PathParam id**: `id` de instancia de ProjectSponsor|Colección de `id` de projects(Project) a asociar|Colección de objetos JSON de projects(Project) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Skill
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Skill, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Skill
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/,
    description: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/skills|Obtener todos los objetos JSON de Skill (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Skill y el total de registros en la base de datos en el header X-Total-Count
**GET**|/skills/:id|Obtener los atributos de una instancia de Skill en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Skill
**POST**|/skills|Crear una nueva instancia de la entidad Skill (CREATE)||Objeto JSON de Skill a crear|Objeto JSON de Skill creado
**PUT**|/skills/:id|Actualiza una instancia de la entidad Skill (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Skill|Objeto JSON de Skill actualizado
**DELETE**|/skills/:id|Borra instancia de Skill en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Skill
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Skill son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|skills/:id/freelancers|Obtener instancias de freelancers(Freelancer) asociados con Skill|**@PathParam id**: `id` de instancia de Skill||Colección de `id` de freelancers(Freelancer) asociados con Skill
**PUT**|skills/:id/freelancers|Actualización de referencias a freelancers(Freelancer) desde Skill|**@PathParam id**: `id` de instancia de Skill|Colección de `id` de freelancers(Freelancer) a asociar|Colección de objetos JSON de freelancers(Freelancer) asociados
**GET**|skills/:id/projects|Obtener instancias de projects(Project) asociados con Skill|**@PathParam id**: `id` de instancia de Skill||Colección de `id` de projects(Project) asociados con Skill
**PUT**|skills/:id/projects|Actualización de referencias a projects(Project) desde Skill|**@PathParam id**: `id` de instancia de Skill|Colección de `id` de projects(Project) a asociar|Colección de objetos JSON de projects(Project) asociados
[Volver arriba](#tabla-de-contenidos)

###Entidad Status
####CRUD Básico
En la siguiente tabla se detalla los servicios REST generados para la entidad Status, la estructura del objeto que intercambian y sus respectivas funciones.

#####Estructura de objeto Status
```javascript
{
    id: '' /*Tipo Long*/,
    name: '' /*Tipo String*/
}
```
#####Servicios
Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|/statuss|Obtener todos los objetos JSON de Status (READ)|**@QueryParam page**: página a consultar<br>**@QueryParam maxRecords**: cantidad de registros a consultar<br><br>*Si se omite alguno de estos parámetros se obtiene todos los registros en la base de datos*||Colección de objetos JSON Status y el total de registros en la base de datos en el header X-Total-Count
**GET**|/statuss/:id|Obtener los atributos de una instancia de Status en formato JSON(READ)|**@PathParam id**: Identificador del registro||Objeto JSON con detalle de la instancia de Status
**POST**|/statuss|Crear una nueva instancia de la entidad Status (CREATE)||Objeto JSON de Status a crear|Objeto JSON de Status creado
**PUT**|/statuss/:id|Actualiza una instancia de la entidad Status (UPDATE)|**@PathParam id**: Identificador del registro|Objeto JSON de Status|Objeto JSON de Status actualizado
**DELETE**|/statuss/:id|Borra instancia de Status en el servidor (DELETE)|<strong>@PathParam id</strong>: Identificador del registro||

####Maestros Detalle de Status
#####Servicios
A diferencia del API para CRUD Básico, el API de Maestro/Detalle no provee un servicio para listar los registros de la entidad maestra. Los servicios generados para el componente Maestro/Detalle de Status son los siguientes:


######Relaciones Shared

Método|URI|Acción|Parámetros|Cuerpo|Retorno
:--:|:--:|:--:|:--:|:--:|:--:
**GET**|statuss/:id/project|Obtener instancias de project(Project) asociados con Status|**@PathParam id**: `id` de instancia de Status||Colección de `id` de project(Project) asociados con Status
**PUT**|statuss/:id/project|Actualización de referencias a project(Project) desde Status|**@PathParam id**: `id` de instancia de Status|Colección de `id` de project(Project) a asociar|Colección de objetos JSON de project(Project) asociados
[Volver arriba](#tabla-de-contenidos)


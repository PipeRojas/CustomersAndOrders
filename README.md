# CustomersAndOrders
Prueba admisión Beitech SAS

## Guía para el desarrollador
___

## API REST

Tipo de datos manejado:  ***JSON***

### Recursos

El API ofrece el los siguientes recursos principales:

- customer
- orden

Este se puede usar así:

### Componentes de los recursos

| Recurso | Metodo | Descripción | Parametro | Retorno |
| :------ | :----- | :---------- | :-------- | :------ |
| `/customer/{customerId}/orden` | **POST** | Guarda una nueva orden para el cliente con id customerId. | | **Orden** |
| `/customer/{customerId}/orden/details` | **POST** | Guarda los detalles de una orden | **Long** customerId | **List**<**OrdenDetail**> |
| `/customer/{customerId}/orden` | **GET** | Retorna las ordenes del cliente con id customerId que estén entre las fechas**from** y **to**. | **Long** customerId, 'from' **Date ('dd/MM/yyyy')**, 'to' **Date ('dd/MM/yyyy')** | **List**<**Orden**> |
| `/persona/{personaId}/` | **GET** | Retorna el recurso de persona específicado por el id| **Long** | **DataPOJO** |
| `/persona/` | **POST** | Guarda la información de un juego nuevo para un paciente registrado. | **TextPlainValue** | |


### Parametros de URL

| Nombre | Tipo | Descripción |
| :----- | :--- | :---------- |
| *personaId* | **Long**| Número de identificación de la persona o paciente. |

### Forma de datos

#### Person

	{	
		"id":Long,
		"name":String,
		"password":String,
		"role":String,
		"edad":Integer,
		"avancesJuegosCalculos":List<AvanceJuegoCalculos>,
		"avancesJuegosImagenes":List<AvanceJuegoImagenes>,
		"diagnosticos":List<Diagnostico>,
	}

#### AvanceJuegoCalculos
  
  	{
		"id":Long,
		"tiempoSegundos":String,
		"numeroPreguntasIntentos":String,
		"numeroPreguntasAciertos":String,
		"PorcentajeSumasResueltas":Integer,
		"PorcentajeRestasResueltas":Integer,
		"PorcentajeMultiplicacionesResueltas":Integer,
		"PorcentajeDivisionesResueltas":Integer,
		"nivelMaximoAlcanzado:String,
		"date":Date
  	}

#### AvanceJuegoImagenes

	{
		"id":Long,
		"tiempoSegundos":String,
		"numeroPreguntasIntentos":String,
		"numeroPreguntasAciertos":String,
		"date":Date
	}

#### Diagnostico

  	{
		"id":Long,
		"title":String,
		"descripcion":String,
		"date":Date,
  	}

_______

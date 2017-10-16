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
| `/customer/{customerId}/orden` | **POST** | Guarda una nueva orden para el cliente con id customerId. | **Long** customerId | **Orden** |
| `/customer/{customerId}/orden/details` | **POST** | Guarda los detalles de una orden | **Long** customerId | **List**<**OrdenDetail**> |
| `/customer/{customerId}/orden?from=@from&to=@to` | **GET** | Retorna las ordenes del cliente con id customerId que estén entre las fechas**from** y **to**. | **Long** customerId, '@from' **Date ('dd/MM/yyyy')**, '@to' **Date ('dd/MM/yyyy')** | **List**<**Orden**> |
| `/customer/{customerId}/` | **GET** | Retorna el recurso de cliente específicado por el id| **Long** | **Customer** |
| `/customer/{customerId}/orden/details` | **GET** | Retorna los detalles de orden para un cliente espedificado por el id. | **Long** | **List**<**OrdenDetail**> |
| `/orden/{ordenId}/detail` | **GET** | Retorna los detalles de orden para una orden espedificada por el id. | **Long** | **List**<**OrdenDetail**> |


### Parametros de URL

| Nombre | Tipo | Descripción |
| :----- | :--- | :---------- |
| *customerId* | **Long**| Número de identificación del cliente. |
| *ordenId* | **Long**| Número de identificación de orden. |

### Forma de datos

#### Customer

	{	
		"customer_id":Long,
		"name":String,
		"email":String,
		"ordens":List<Orden>,
		"customer_available_products":Set<Product>,
	}

#### Orden
  
  	{
		"orden_id":Integer,
		"delivery_address":String,
		"customer_id":Long,
		"date":Date,
		"customer":Customer,
		"orden_detail":Set<OrdenDetail>
  	}

#### OrdenDetail

	{
		"pk":OrdenDetailId,
		"quantity":Integer,
		"product_description":String
	}

#### OrdenDetailId

  	{
		"orden":Orden,
		"product":Product
  	}
    
#### Product

    {
      "product_id":Integer,
      "name":String,
      "price":Integer,
      "availableForCostumers": List<Customer>,
      "orden_detail": Set<OrdenDetail>
    }

_______

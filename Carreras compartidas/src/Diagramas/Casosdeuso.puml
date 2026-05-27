@startuml
left to right direction

actor Conductor as c
actor Pasajero as p
actor Administrador as a

package Carreras compartidas{

 usecase "Gestionar Viajes" as uc1
 usecase "confirmar pasajeros" as uc2
 usecase "Gestionar usuarios" as uc3
 usecase "Gestionar vehiculos" as uc4
 usecase "Gestionar reservas" as uc5
 usecase "Gestionar pagos" as uc6
} 
  c -- uc1
  c -- uc2 
  c -- uc5
  c -- uc4
  uc1 -- p
  uc5 -- p 
  uc6 -- p
  a -- uc3
  a -- uc4
  a -- uc5
  a -- uc6
@enduml

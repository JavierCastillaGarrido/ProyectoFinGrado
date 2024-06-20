<template>
    <div id="containerUser">
        <h1 class="tituloPag">Zona de User</h1>
        <div class="fondoCitas">
            <div class="listadoCitas">
                <h2>Citas del User</h2>
                <table>
                    <tr>
                        <th>Id Cita</th>
                        <th>Fecha</th>
                        <th>Nombre</th>
                        <th>Tatuador</th>
                        <th>Descripción</th>
                        <th>Tamaño</th>
                        <th>Precio</th>
                    </tr>
                    <tr class="citas" v-for="(item, index) in listaMostrar" :key="index">
                        <td> {{ item.idCitas }} </td>
                        <td> {{ item.fecha }} </td>
                        <td> {{ item.cliente.nombre }} </td>
                        <td> {{ item.tatuador.nombre }} </td>
                        <td> {{ item.tatuajes.descripcion }} </td>
                        <td> {{ item.tatuajes.tamano }} cm</td>
                        <td> {{ item.tatuajes.precio }} €</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
      props: {},
      data() {
        return { 
            listaCitas: [],
            listaMostrar: [],
            email:""
        }
      },
      methods: {
        async rellenarListaCitas(){
            await fetch('http://localhost:8080/tiendaTattoos/citas')
                .then(response => response.json())
                .then(json => {this.listaCitas = json
                    console.log(this.listaCitas);
                });
                
            for (let i = 0; i < this.listaCitas.length; i++) {
                if ((this.listaCitas[i].cliente.email) === this.email) {
                    this.listaMostrar.push(this.listaCitas[i]);
                }
            }

            console.log(this.listaMostrar);

        }
      },
      created() {
        this.email = this.$route.params.email;
        this.rellenarListaCitas();
      }
    }
</script>

<style>

.fondoCitas{
    background-color: rgba(51, 51, 51, 0.8);
    margin-bottom: 2%;
}

.listadoCitas{
    width: 70%;
    background-color: rgba(248, 212, 197, 0.8);
    margin: auto;
    padding: 2%;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.listadoCitas h2{
    text-align: center;
}

table{
    width: 80%;
}

table,th,tr,td{
    text-align: center;
    border: 1px solid black;
    border-collapse: collapse;
}

th{
    background-color: rgba(51, 51, 51, 0.7);
}

th,td{
    padding: 1%;
}
</style>
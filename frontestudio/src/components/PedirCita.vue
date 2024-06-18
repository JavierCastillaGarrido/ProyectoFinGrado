<template>
    <div class="divformulario">
        <h1>Formulario Citas</h1>
        <p :focus="true"> {{id}}</p>

<!---  MODIFICAR PARA PEDIR CITAS ESTA COMO NUEVO JUGADOR  -->

        <div class="formulario">
        <label for="nombrej">Nombre del nuevo Jugador: </label><br>
        <input type="text" name="nombrej" id="nombrej" v-model="nombre" required> <br><br>
    
        <label for="equipo">Equipo: </label>
        <select name="equipo" id="equipo" v-if="(NombreEquipo == '')" v-model="equipo" required>
            <option value="" selected disabled>Seleccione una opcion</option>
            <option v-for="item in equipos" :key="item.id" :value="item.name"> {{ item.name }}</option>
        </select> 
        <select name="equipo" id="equipo" v-if="(NombreEquipo != '')" disabled required>
            <option :value="NombreEquipo" selected >{{ NombreEquipo }}</option>
        </select> <br><br> 
        <label for="goles">Goles marcados por el Jugador: </label> <br>
        <input type="number" name="goles" id="goles" min="0" v-model="goles" required>
        <button type="button" @click="guardarNuevoJugador()"> Guardar Nuevo Jugador</button>
    </div>
    </div>
</template>

<script>
    export default {
        props: ["id"],
        data(){
            return{
                listaCitas:[],
            }
        },
        methods:{
            listarCitas() {
                fetch('http://localhost:8080/tiendaTattoos/citas')
                    .then(response => response.json())
                    .then(json =>  this.listaCitas = json);
            },
        },
        created(){
            this.listarCitas();
        }
    }
</script>

<style>

</style>
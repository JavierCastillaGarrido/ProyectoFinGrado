<template>
    <div class="divformulario">
        <h1 class="tituloPag">Formulario Citas</h1>
        <div class="formulario">
            <div class="info">
                <div class="infoclient">
                    <h2>Información cliente</h2>
                    <label for="nombrec">Nombre: </label><br>
                    <input type="text" name="nombrec" id="nombrec" v-model="nombrec" required autofocus> <br><br>
                    <label for="apellidos">Apellidos: </label><br>
                    <input type="text" name="apellidos" id="apellidos" v-model="apellidos" required> <br><br>
                    <label for="telefono">Teléfono: </label><br>
                    <input type="text" name="telefono" id="telefono" v-model="telefono" required> <br><br>
                    <label for="email">Correo electronico: </label><br>
                    <input type="email" name="email" id="email" v-model="email" required> <br><br>
                </div>
                <div class="infoTatus">
                    <h2>Información Tatuaje</h2>
                    <label for="descrip">Descripción del tatuaje: </label><br>
                    <input type="text" name="descrip" id="descrip" v-model="descrip" required> <br><br>
                    <label for="color">Color:</label><br>
                    <input type="checkbox" name="color" id="color" v-model="color" :on-change="calcularPrecio()"> <br><br>
                    <label for="tamano">Tamaño:</label><br>
                    <input type="number" required v-model="tamano" placeholder="ejem: 5.2" :on-change="calcularPrecio()"> <br><br>
                    <label for="precio">Precio Total:</label> <br>
                    <input type="text" name="precio" id="precio" v-model="precio" disabled>
                </div>
                <div class="infoCitas">
                    <h2>Información Cita</h2>
                    <label for="tatuador">Nombre del Tatudor:</label><br>
                    <select name="tatuador" id="tatuador" v-if="(nomTatuador == '')" v-model="nomTatuador" required>
                        <option value="" selected disabled>Seleccione una tatuador</option>
                        <option v-for="item in listaTatuadores" :key="item.idTatuadores" :value="item.nombre"> {{ item.nombre }}</option>
                    </select>  
                    <select name="tatuador" id="tatuador" v-if="(nomTatuador != '')" required>
                        <option :value="nomTatuador" selected >{{ nomTatuador }}</option>
                    </select> <br><br> 
        
                    <label for="fecha">Fecha de Cita:</label><br>
                    <input type="date" name="fecha" id="fecha" required v-model="fecha">
                
                </div>
            </div>
            <button type="button" class="botonCita" @click="pedirCita() ">Pedir cita</button>
        </div>
    </div>
</template>

<script>
    export default {
        props: ["nombreTatuadores"],
        data(){
            return{
                nomTatuador: "",
                listaCitas:[],
                listaTatuadores:[],
                listaClientes:[],
                listaTatuajes:[],
                nombrec:"",
                apellidos: "",
                telefono: "",
                email: "",
                descrip: "",
                color: null,
                tamano: "",
                precio: 0,
                fecha: ""    

            }
        },
        /* reaccionar a los cambios en el nombreTatuadores y actualiza automaticamente */
        watch: {
            nombreTatuadores: function(newVal) {
                this.nomTatuador = newVal;
            }
        },
        methods:{
            listarCitas() {
                fetch('http://localhost:8080/tiendaTattoos/citas')
                    .then(response => response.json())
                    .then(json => this.listaCitas = json);

                fetch('http://localhost:8080/tiendaTattoos/tatuadores')
                    .then(response => response.json())
                    .then(json => this.listaTatuadores = json);

                fetch('http://localhost:8080/tiendaTattoos/clientes')
                    .then(response => response.json())
                    .then(json => this.listaClientes = json);

                fetch('http://localhost:8080/tiendaTattoos/tatuajes')
                    .then(response => response.json())
                    .then(json => this.listaTatuajes = json);
            },
            calcularPrecio(){
                if(this.tamano == 0 || this.tamano === "") {
                    return;
                }
                var c;
                if(this.color){
                    c = 1;
                }else{
                    c = 0;
                }

                var datos ={
                    color: c,
                    tamano: this.tamano
                };
                fetch('http://localhost:8080/tiendaTattoos/tatuajes/calcularPrecio', {
                    method: 'POST',
                    headers: {'Content-Type': 'application/json'},
                    body: JSON.stringify(datos) 
                }).then(response => {
                    if (!response.ok) {
                        throw new Error('Error en la respuesta del servidor: ' + response.statusText);
                    }
                    return response.text(); 
                })
                .then(data => {
                    this.precio = data;
                })
                .catch(error => {
                    console.error('Error al calcular el precio:', error);
                });
            }

            /*pedirCita() {
            // Aquí puedes manejar la lógica para enviar el formulario de cita.
            // Ejemplo de un POST request
            const nuevaCita = {
                nombrec: this.nombrec,
                apellidos: this.apellidos,
                telefono: this.telefono,
                email: this.email,
                descrip: this.descrip,
                color: this.color,
                tamano: this.tamano,
                nomTatuador: this.nomTatuador,
                fecha: this.fecha
            };
            
            fetch('http://localhost:8080/tiendaTattoos/citas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(nuevaCita)
            })
            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                // Aquí puedes manejar la respuesta exitosa, tal vez limpiando el formulario o mostrando un mensaje de éxito.
            })
            .catch((error) => {
                console.error('Error:', error);
                // Aquí puedes manejar errores.
            });*/
        },
        created(){
            this.listarCitas();
            this.nomTatuador = this.nombreTatuadores;
        }
    }
</script>

<style>

.divformulario{
    display: flex;
    flex-direction: column;
    width: 70%;
    margin: 1% auto 3%;
}

.botonCita{
    cursor: pointer;
    margin: 2% auto;
    width: 80%;
    padding: 1% 5%;
    border: 0px;
    border-radius: 18px;
    color: white;
    font-size: larger;
    background-color: rgba(51, 51, 51, 0.8);
    transition: 1s;
}

.botonCita:hover{
    transition: 1s;
    background-color: #fd5437;
}

.formulario{
    text-align: center;
    background-color: white;
    border-radius: 18px;
    display: flex;
    flex-direction: column;
}

.info{
    display: flex;
    flex-direction: row;
}

.info input, select{
    width: 60%;
    margin: 1%;
}

.infoclient, .infoTatus, .infoCitas{
    width: 33%;
    align-self: center;
}

</style>
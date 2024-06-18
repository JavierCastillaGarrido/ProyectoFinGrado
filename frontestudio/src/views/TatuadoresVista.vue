<template>
  <div id="contenedorTatuadores">
    <h1 class="tituloPag">TATUADORES</h1>
    <div id="tarjetasTatuadores">
      <div v-for="(item, index) in listaTatuadores" :key="index" class="tarjeta">
        <img :src="item.imagen" alt="">
        <div class="contenidoTarjeta">
          <h2>{{ item.nombre }} {{ item.apellidos }}</h2>
          <p>{{ item.descripcion }}</p>
          <button @click="mostrarcita(item.idTatuadores)">Pedir cita</button>
        </div>
      </div>
      <div :hidden="booleana">
            <PedirCita :id="idTatuadores"></PedirCita>
      </div>
    </div>
  </div>
  
</template>
  
<script>

import PedirCita from '@/components/PedirCita.vue';

    export default {
      props: {},
      components:{
        PedirCita
      },
      data() {
        return { 
          listaTatuadores: [],
          imagenes: ["https://picsum.photos/200/200", "https://picsum.photos/200/200/", "https://picsum.photos/200/200//"],
          booleana: true,
          idTatuadores: ""
        }
      },
      methods: {
        listarTatuadores() {
          fetch('http://localhost:8080/tiendaTattoos/tatuadores')
            .then(response => response.json())
            .then(json => {
              this.listaTatuadores = json;
              this.listaTatuadores.forEach((element, index) => {
                element.imagen = this.imagenes[index % this.imagenes.length];
                console.log(element);
              });
            });
        },
        mostrarcita(id){
            this.booleana = false;
            this.idTatuadores = id;
        }
      },
      created() {
       this.listarTatuadores(); 
      }
    };
</script>
  
<style>
#contenedorTatuadores{
  display: flex;
  flex-direction: column;
}

.tituloPag{
  margin: 4% auto 2%;
  padding: 1%;
  width: 20%;
  text-align: center;
  color: white;
  background-color: rgba(51, 51, 51, 0.8);
  border-radius: 18px;
}

#tarjetasTatuadores{
  display: flex;
  flex-direction: column;
  background-color: rgba(51, 51, 51, 0.8);
  margin-bottom: 2%;
}

.tarjeta{
  width: 70%;
  background-color: white;
  margin: auto;
  padding: 2%;
  display: flex;
  align-items: center;
}

.tarjeta img{
  border-radius: 50%;
  margin: 3%;
}

.tarjeta p {
  text-align: justify;
  margin-right: 5%;
}

.contenidoTarjeta button{
  margin: 1%;
  border: 0;
  color: white;
  background-color: rgba(51, 51, 51, 0.8);
  padding: 1% 2%;
}

.contenidoTarjeta button:hover{
  cursor: pointer;
  transition: 0.5s;
  background-color: #fd5437;
}

</style>
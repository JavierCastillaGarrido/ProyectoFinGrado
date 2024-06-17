<template>
  <div id="contenedorTatuadores">
    <h1 class="tituloPag">TATUADORES</h1>
    <div id="tarjetasTatuadores">
      <div>
        <h2></h2>
        <p></p>
      </div>
    </div>
  </div>
</template>
  
<script>
    export default {

    };
</script>
  
<style scoped>
#contenedorTatuadores{
  display: flex;
  flex-direction: column;
}

.tituloPag{
  margin: 4% auto 2%;
  padding: 1%;
  width: 15%;
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

</style>
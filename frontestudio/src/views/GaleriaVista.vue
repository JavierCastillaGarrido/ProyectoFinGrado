<template>
    <div>
        <h1>GALERIA</h1>
        <div class="cuadroimagen">
            <p>{{ imagenes.imagenes }}</p>
            <img src='anadeImagenes()' alt="imagen">
            <p></p>
        </div>
    </div>
</template>
  
<script>
export default {
    name: "galeriaVista", 
    data() {
        return {
            imagenes: []
        }
    },
    methods: {
        recogerImagenes() {
            fetch('http://localhost:8080/tiendaTattoos/imagenes/1')
            .then(response => response.json())
            .then(json => this.imagenes = json)
        },
        anadeImagenes() {
            let img = "data:image/jpeg;base64" + this.imagenes.imagen;
            return img;
        }
    },
    created() {
        this.recogerImagenes();
    }

}
</script>
  
<style scoped>
.cuadroimagen {
    background-color: white;
    height: 100px;
    width: 100px;
    margin: auto;
}
</style>
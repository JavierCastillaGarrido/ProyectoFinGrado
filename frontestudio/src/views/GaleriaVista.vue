<template>
    <div>
        <h1>GALERIA</h1>
    </div>
</template>
  
<script>
export default {
    name: "galeriaVista", 
    data() {
        return {
            images: {}
        }
    },
    methods: {
        recogerImagenes() {
            fetch("http://localhost:8080/imagenes")
            .then(response => response.json())
            .then(json => this.imagenes = json)
        },
        
    }

}
</script>
  
<style scoped></style>
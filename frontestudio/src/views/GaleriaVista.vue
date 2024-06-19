<template>
  <div>
    <h1 class="tituloPag">GALERIA</h1>
    <div class="galeria">
      <div class="cuadroimagen">
        <div>
          <img :src="img" alt="tattoo1" />
        </div>
        <div>
          <img :src="img2" alt="tattoo2" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/1.webp" alt="tattoo3" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/2.jpg" alt="tattoo4" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/realista.jpg" alt="tattoo5" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/acuarela.jpg" alt="tattoo6" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/acuarela2.jpg" alt="tattoo7" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/7.webp" alt="tattoo9" />
        </div>
        <div>
          <img src="../assets/ImagenesTattoos/realista2.jpg" alt="tattoo8" />
        </div>
      </div>
    </div>
  </div>
</template>
  
<script>
export default {
  name: "galeriaVista",
  data() {
    return {
      imagenes: [],
      img: "",
      img2: "",
    };
  },
  methods: {
    recogerImagenes() {
      fetch("http://localhost:8080/tiendaTattoos/imagenes/1")
        .then((response) => response.json())
        .then((json) => {
          this.imagenes = json;
          this.img = "data:image/png;base64," + this.imagenes.imagenes;
          this.img2 =
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABgAAAAYCAYAAADgdz34AAAABHNCSVQICAgIfAhkiAAAAAlwSFlzAAAApgAAAKYB3X3/OAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAANCSURBVEiJtZZPbBtFFMZ/M7ubXdtdb1xSFyeilBapySVU8h8OoFaooFSqiihIVIpQBKci6KEg9Q6H9kovIHoCIVQJJCKE1ENFjnAgcaSGC6rEnxBwA04Tx43t2FnvDAfjkNibxgHxnWb2e/u992bee7tCa00YFsffekFY+nUzFtjW0LrvjRXrCDIAaPLlW0nHL0SsZtVoaF98mLrx3pdhOqLtYPHChahZcYYO7KvPFxvRl5XPp1sN3adWiD1ZAqD6XYK1b/dvE5IWryTt2udLFedwc1+9kLp+vbbpoDh+6TklxBeAi9TL0taeWpdmZzQDry0AcO+jQ12RyohqqoYoo8RDwJrU+qXkjWtfi8Xxt58BdQuwQs9qC/afLwCw8tnQbqYAPsgxE1S6F3EAIXux2oQFKm0ihMsOF71dHYx+f3NND68ghCu1YIoePPQN1pGRABkJ6Bus96CutRZMydTl+TvuiRW1m3n0eDl0vRPcEysqdXn+jsQPsrHMquGeXEaY4Yk4wxWcY5V/9scqOMOVUFthatyTy8QyqwZ+kDURKoMWxNKr2EeqVKcTNOajqKoBgOE28U4tdQl5p5bwCw7BWquaZSzAPlwjlithJtp3pTImSqQRrb2Z8PHGigD4RZuNX6JYj6wj7O4TFLbCO/Mn/m8R+h6rYSUb3ekokRY6f/YukArN979jcW+V/S8g0eT/N3VN3kTqWbQ428m9/8k0P/1aIhF36PccEl6EhOcAUCrXKZXXWS3XKd2vc/TRBG9O5ELC17MmWubD2nKhUKZa26Ba2+D3P+4/MNCFwg59oWVeYhkzgN/JDR8deKBoD7Y+ljEjGZ0sosXVTvbc6RHirr2reNy1OXd6pJsQ+gqjk8VWFYmHrwBzW/n+uMPFiRwHB2I7ih8ciHFxIkd/3Omk5tCDV1t+2nNu5sxxpDFNx+huNhVT3/zMDz8usXC3ddaHBj1GHj/As08fwTS7Kt1HBTmyN29vdwAw+/wbwLVOJ3uAD1wi/dUH7Qei66PfyuRj4Ik9is+hglfbkbfR3cnZm7chlUWLdwmprtCohX4HUtlOcQjLYCu+fzGJH2QRKvP3UNz8bWk1qMxjGTOMThZ3kvgLI5AzFfo379UAAAAASUVORK5CYII=";
        });
    },
  },
  created() {
    this.recogerImagenes();
  },
};
</script>
  
<style scoped>
.galeria {
  background-color: rgba(51, 51, 51, 0.8);
}
.cuadroimagen {
  grid-area: seccion;
  height: 100%;
  width: 80%;
  margin: 2% auto;
  padding: 0.7%;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  align-items: stretch;
  grid-gap: 1%;
}

.cuadroimagen > div {
  background-color: azure;
}

.cuadroimagen > div > img {
  height: 100%;
  width: 100%;
}
</style>
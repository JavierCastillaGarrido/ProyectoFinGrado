<template>
  <div id="contenerdorInicio">
    <div id="imagenLogo">
      <img src="../assets/Logo.png" alt="logo">
    </div>
    <h1>Drawtatoo</h1>
    <div id="texto"> 
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ad dignissimos laudantium dolorem, non, in ipsam reprehenderit dolore accusantium tempora eveniet accusamus consequuntur doloremque blanditiis hic rem optio ea. Eaque impedit itaque consequatur, doloribus inventore, aperiam magnam necessitatibus saepe modi tenetur ratione? Repellendus expedita accusantium facere. Nisi non aspernatur ea ab inventore commodi architecto optio, porro animi et consequatur veniam quia voluptates nobis, quidem, tenetur assumenda facere. Similique iure doloremque porro a iusto nostrum ducimus blanditiis molestiae hic sed saepe magnam maiores illo, illum labore amet possimus error, at eius? Unde facere, consectetur quos autem adipisci perspiciatis doloremque quasi fugit voluptas? Corrupti ipsa quod et porro error accusantium libero, culpa deserunt nostrum ipsum recusandae! Perspiciatis vitae exercitationem minus eum nostrum est! Consectetur, dolor dicta. Dolores dolorum quia voluptatum doloremque nobis totam quisquam perspiciatis qui laudantium laborum harum modi ipsum incidunt, tempore ipsa dolore inventore quas accusantium. Temporibus numquam reprehenderit quae repudiandae omnis porro magni maiores veniam. Illo explicabo quibusdam pariatur eveniet, ab delectus adipisci. Cumque placeat optio ratione ea necessitatibus facilis nobis magnam aliquid reprehenderit quas aperiam provident id deserunt quisquam consectetur officia mollitia excepturi corrupti asperiores, fuga possimus quidem. Voluptatibus, dolorum? Perferendis at quis fugiat earum nulla quo adipisci pariatur voluptate soluta ea, quae, sunt optio quam sapiente quasi vero quibusdam amet quisquam. Qui veritatis eaque, beatae, est ipsum tempore fuga cupiditate saepe obcaecati ab recusandae ipsa veniam voluptate, numquam itaque asperiores? Inventore mollitia ipsa facere obcaecati ullam ut quo expedita reiciendis, architecto odit alias ab! Cumque aut nobis excepturi.</p>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#contenerdorInicio{
  display: flex;
  flex-direction: column;
  text-align: center;
  color: white;
  padding: 5% 0.01%;
}

#imagenLogo img{
  border-radius: 50%;
  width: 15%;
}

h1 {
  font-size: 10em;
  font-family: 'Times New Roman', Times, serif;
  margin-top: 0;
}

#texto{
  margin: 2.5% auto 2.5%;
  width: 80%;
  color: black;
  background-color: azure;
  border-radius: 18px;
  
}

#texto p{
  padding: 2% 5%;
  text-align: justify;
}

</style>
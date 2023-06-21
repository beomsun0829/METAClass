<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
    name: 'Header',
});
</script>

<template>
    <header class="header">
        <h1 class="site-title">META Class</h1>
        <nav class="navigation">
            <a href="/" class="nav-link">Home</a>
            <a href="/board" class="nav-link">Board</a>
            <a href="/screen" class="nav-link">Screen</a>
            <a href="/about" class="nav-link">About</a>
        </nav>
        <div class="profile-container">
          <img class="profile-picture" src="./icons/user.png"/>
        </div>
    </header>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;500&display=swap');

.header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px 30px;
    background-color: #92b7d9;
    box-shadow: 0 2px 4px 0 rgba(0, 0, 0, 0.2);
    color: #122540;
    font-family: 'Poppins', sans-serif;
}

.site-title {
    font-size: 1.5rem;
    font-weight: 500;
}

.navigation {
    display: flex;
}

.nav-link {
  position: relative;
  margin-left: 20px;
  margin-right: 20px;
  font-size: 1.1rem;
  text-decoration: none;
  color: #122540;
  transition: color 0.3s ease;
}

.nav-link::after {
  content: '';
  position: absolute;
  bottom: -5px;
  left: 0;
  right: 0;
  height: 2px;
  background-color: #0765d7;
  transform: scaleX(0);
  transition: transform 0.3s ease;
}

.nav-link:hover {
  color: #0765d7;
}

.nav-link:hover::after {
  transform: scaleX(1);
}


.profile-picture {
    height: 50px;
    width: 50px;
    border-radius: 50%;
}

</style>

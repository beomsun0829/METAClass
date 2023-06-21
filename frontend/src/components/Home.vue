<template>
    <div class="container">
        <div class="animate-me" v-for="(item, index) in items" :key="index">
            <span v-for="(letter, i) in item.split('')" :key="i">{{ letter }}</span>
        </div>
    </div>
</template>

<script lang="ts">
import { defineComponent, onMounted, ref } from 'vue';
import anime from "animejs/lib/anime.es.js";

export default defineComponent({
    name: 'Home',
    setup() {
        const items = ref([
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
            'Hello World! Hello World! Hello World!',
        ]);

        onMounted(() => {
            const longestItemLength = Math.max(...items.value.map(item => item.length));
            const animation = anime.timeline({
                targets: ".animate-me span",
                delay: anime.stagger(80, {
                    grid: [longestItemLength, items.value.length],
                    from: "center"
                }),
                loop: true
            });

            animation
                .add({
                    scale: 0.5
                })
                .add({
                    letterSpacing: "13px"
                })
                .add({
                    scale: 1
                })
                .add({
                    letterSpacing: "8px"
                });
        });

        return { items };
    },
});
</script>

<style scoped>
.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: calc(100vh - 78.52px);
    background-color: #222;
    overflow : hidden;
}

.animate-me {
    color: #fff;
    font-weight: 400;
    font-size: 1.8vw;
    text-align: center;
    text-transform: uppercase;
    font-family: "Khula", sans-serif;
    box-sizing: border-box;
    letter-spacing: 8px;
    margin: 0;
    line-height: 1.2;
    margin-bottom: 40px;
}

.animate-me span {
    display: inline-block;
}
</style>

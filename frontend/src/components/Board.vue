<script lang="ts">
export default {
    name: 'BoardList',
    data() {
        return {
            boards: [
                { id: 1, name: 'Board 1' },
                { id: 2, name: 'Board 2' },
                { id: 3, name: 'Board 3' },
            ],
        };
    },
};
</script>

<template>
    <div class="board-list">
        <h1>게시판</h1>
        <ul>
            <li v-for="board in boards" :key="board.id">
                {{ board.name }}
            </li>
        </ul>
    </div>
</template>

<style scoped>
.board-list {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.board-list h1 {
    text-align: center;
    padding: 0;
}

.board-list ul{
    padding: 0;
}
.board-list li {
    list-style: none;
}
</style>


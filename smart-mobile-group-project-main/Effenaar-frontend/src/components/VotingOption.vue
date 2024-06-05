<template>
    <div class="voteOptionBackground">
        <img class="voteOptionImage" :src="this.image" :style="{borderColor: color}">
    </div>
</template>

<script>
export default {
    props: {
        name: null,
        image: null,
        color: String,
    },
    data(){
        return {
            Item: {
                ItemName: this.name,
                ItemImage: this.image,
            },
        }
    },
}
</script>

<style scoped>
.voteOptionImage{
    max-width: 100px;
    height: 100px;
    border-radius: 10px;
    border-style: solid;
    border-width: 5px;
}
.voteOptionBackground{
    width: fit-content;
    margin: 5px;
    margin-top: 10px;
    background-color: orange;
}

</style>
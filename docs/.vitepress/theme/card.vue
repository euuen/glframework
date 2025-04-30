<template>
    <div :class = "cla">
        <slot></slot>
    </div>
</template>

<script setup lang="ts">
import { ref, watch} from 'vue'
import { useData } from 'vitepress';

const { isDark } = useData();

const cla = isDark ? ref("darkcard") : ref("lightcard");

watch(
    isDark,
    ()=>{
        cla.value = isDark ? ref("darkcard") : ref("lightcard");
    }
);

</script>
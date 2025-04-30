// https://vitepress.dev/guide/custom-theme
import { h } from 'vue'
import { useData, useRoute, type Theme } from 'vitepress'
import DefaultTheme from 'vitepress/theme'
import './style.css'
import giscusTalk from 'vitepress-plugin-comment-with-giscus'
import Card from './card.vue'

export default {
  extends: DefaultTheme,
  Layout: () => {
    return h(DefaultTheme.Layout, null, {
      // https://vitepress.dev/guide/extending-default-theme#layout-slots
    })
  },
  enhanceApp({ app, router, siteData }) {
    // ...
    app.component("card", Card)
  },
    setup(){
        const { frontmatter } = useData();
        const route = useRoute();
        giscusTalk({
            repo: 'euuen/glframework', 
            repoId: 'R_kgDONwM_Yw',   
            category: 'Announcements', // default: `General` 
            categoryId: 'DIC_kwDONwM_Y84CoZpe', 
            mapping: 'pathname', // default: `pathname`
            inputPosition: 'top', // default: `top`
            lang: 'zh-CN', // default: `zh-CN`
            lightTheme: 'light', // default: `light`
            darkTheme: 'transparent_dark', 
            loading: "lazy"
          },{
            frontmatter, route
          }, true);
    }
} satisfies Theme

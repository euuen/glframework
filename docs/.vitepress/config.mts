import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
  base: "/glframework",
  title: "GLFramework",
  description: "The document of glframework",
  themeConfig: {
    // https://vitepress.dev/reference/default-theme-config
    nav: [
        { text: 'GLFramework', link: '/glframework/intro' },
        { text: 'AMC', link: '/amc/intro' }
    ],

    sidebar: {
        "glframework": [

        ],
        "amc": [
          	{
              text: "简介",
              link: "/amc/intro"
          	},
            {
              text: "教程",
              collapsed: false,
              items :[
                { text: "第一章：Hello AMC", link: '/amc/tutor/helloAMC' }
              ]
            },
            {
              text: "API",
              collapsed: false,
              items: [
                { text: "Application", link: "/amc/api/Application" }
              ]
            }
        ]
    },

    socialLinks: [
        { icon: 'github', link: 'https://github.com/euuen' }
    ]
  }
})

import { defineConfig } from 'vitepress'

// https://vitepress.dev/reference/site-config
export default defineConfig({
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
				text: "API",
				collapsed: false,
				items: [
					{ text: "Application", link: "/amc/Application" }
				]
			}
        ]
    },

    socialLinks: [
        { icon: 'github', link: 'https://github.com/euuen' }
    ]
  }
})

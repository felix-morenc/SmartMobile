const cacheName="TestCache_V1";

const appFiles=[
	"manifest.json",
	"./",
  "index.html"
];

self.addEventListener("install",(installing)=>{
    //Put important offline files in cache on installation of the service worker
    installing.waitUntil(
      caches.open(cacheName).then((cache)=>{
      console.log("Service Worker: Caching important offline files");
      return cache.addAll(appFiles);
      })
  );
  });
  
  self.addEventListener("activate",(activating)=>{	
    console.log("Service Worker: All systems online, ready to go!");
  });
  
  self.addEventListener("fetch",(fetching)=>{   
    console.log("Service Worker: User threw a ball, I need to fetch it!");
  });
  
  self.addEventListener("push",(pushing)=>{
      console.log("Service Worker: I received some push data, but because I am still very simple I don't know what to do with it :(");
  })
  
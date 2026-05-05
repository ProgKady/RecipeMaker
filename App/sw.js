const CACHE_NAME = 'tc-wasel-v1';
const ASSETS = [
  '/',
  '/index.html',
  '/manifest.json',
  '/hrrr.png',
  // أضف هنا ملفات CSS/JS الأساسية والمسارات للصور
];

self.addEventListener('install', e => {
  e.waitUntil(caches.open(CACHE_NAME).then(cache => cache.addAll(ASSETS)));
  self.skipWaiting();
});

self.addEventListener('fetch', e => {
  e.respondWith(
    caches.match(e.request).then(res => res || fetch(e.request))
  );
});

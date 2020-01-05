(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]))

(defn welcome
  "a ring handler to process all requests sent to the webapp"
  [request]
  {:status 200
   :headers {}
   :body "<html> <body> <h1>Hello, Clojure World!</h1> <p>Welcome to your first Clojure app!</p> <p>This message is returned regardless of the request</p> </body> </html>"})

(defn -main
  [port-number]
  (webserver/run-jetty
   welcome
   {:port (Integer. port-number)
    :join? false}))

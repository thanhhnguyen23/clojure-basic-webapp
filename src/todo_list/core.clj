(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]))

(defn -main
  "simple web server using ring/jetty"
  [port-number]
  (webserver/run-jetty
   (fn [request]
     {:status 200
      :headers {}
      :body "<html><body><h1>Hello, Clojure World!</h1><h2>Welcome to your first Clojure App</h2<h3>This message is returned regardless of the request</h3></body></html>"})
   {:port (Integer. port-number)
    :join? false}))

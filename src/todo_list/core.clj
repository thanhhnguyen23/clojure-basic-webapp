(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn welcome
  "a ring handler to process all requests sent to the webapp. if a request is for something other than `/` then an error message is returned"
  [request]
  (if (= "/" (:uri request))
    {:status 200
     :headers {}
     :body "<html> <body> <h1>Hi Thanh! Welcome to the Clojure World!</h1> <p>Welcome to your first Clojure app!</p> <p>This message is returned regardless of the request</p> </body> </html>"}

  {:status 404
   :body "<html> <body> <h1>ERROR</h1> <p>This is probably not the page you are looking for.</p> <p>Requested page was not found</p> </body> </html>"
   :headers {}}))

(defn -dev-main
  ;; -main
  [port-number]
  (webserver/run-jetty
   (wrap-reload #'welcome)
   {:port (Integer. port-number)
    :join? false}))

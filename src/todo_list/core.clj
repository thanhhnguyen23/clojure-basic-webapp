(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]
            [ring.middleware.reload :refer [wrap-reload]]

            ;; add compojure to namespace
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))


(defn welcome
  "a ring handler to respond witha simple welcome message"
  [request]
    {:status 200
     :headers {}
     :body "<html> <body> <h1>Hi Thanh! Welcome to the Clojure World!</h1> <p>Welcome to your first Clojure app!</p>
<p>Now this updates automatically.</p>
</body> </html>"
     })

(defroutes app
  (GET "/" [] welcome)
  (not-found " <h1>This is not the page you are looking for</h1><p>The page you are requested was not found.</p> "))

(defn -main
  "A very simple web server using Ring & Jetty"
  [port-number]
  (webserver/run-jetty
   {:port (Integer. port-number)}))

(defn -dev-main
  "A very simple web server using Ring & Jetty that reloads code changes via the development profile of Leiningen"
  [port-number]
  (webserver/run-jetty (wrap-reload #'app)
   {:port (Integer. port-number)}))

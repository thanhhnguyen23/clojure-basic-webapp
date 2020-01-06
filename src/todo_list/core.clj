(ns todo-list.core
  (:require [ring.adapter.jetty :as webserver]
            [ring.middleware.reload :refer [wrap-reload]]

            ;; add compojure to namespace
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]

            ;; compojure's request dump function
            [ring.handler.dump :refer [handle-dump]]))

(defn hello
  "a simple personalized greeting showing the use of variables path elements"
  [request]
  (let [name (get-in request [:route-params :name])]
    {:status 200
     :headers{}
     :body (str "Hello " name ". I got your name from the web URL")}))

(defn about
  "information about the website developer"
  [request]
  {:status 200
   :headers {}
   :body "<h1>About Page</h1> <h2>I'm getting comfortable with Clojure</h2> "})

(defn welcome
  "a ring handler to respond witha simple welcome message"
  [request]
    {:status 200
     :headers {}
     :body "<html> <body> <h1>Hi Thanh! Welcome to the Clojure World!</h1> <p>Welcome to your first Clojure app!</p>
<p>Now this updates automatically.</p>
</body> </html>"})

(defn goodbye
  "goodbye route"
  [request]
  {:status 200
   :headers{}
   :body " <h1>Goodbye!</h1> <p>There's never a right time to say goodbye</p> <p>But we know that we gotta go</p> <p>Our separate ways</p> "})

(defroutes app
  (GET "/" [] welcome)
  (GET "/goodbye" [] goodbye)
  (GET "/about" [] about)
  (GET "/request-info" [] handle-dump)
  (GET "/hello/:name" [] hello)
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

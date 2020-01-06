(defproject todo-list "0.1.0-SNAPSHOT"
  :description "a todo list server-side web app using ring & compojure"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [ring "1.8.0"]
                 [compojure "1.6.1"]]
  :repl-options {:init-ns todo-list.core}

  ;; add profile to project configuration
  :profiles {:dev
             {:main todo-list.core/-dev-main}}
  :main todo-list.core) ;; configuration option

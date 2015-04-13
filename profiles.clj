{:user
 {:jvm-opts ["-XX:-OmitStackTraceInFastThrow"]
  :plugins [;; REPL
            [cider/cider-nrepl "0.9.0-SNAPSHOT"]
            [refactor-nrepl "0.2.2"]

            ;; Application server
            [lein-immutant "2.0.0-SNAPSHOT"]

            ;; Automated testing
            [lein-cloverage "1.0.2"]
            [lein-test-out "0.3.1"]

            ;; Package management
            [lein-ancient "0.6.3"]
            [lein-licenses "0.2.0"]
            [lein-clojars "0.9.1"]

            ;; Documentation
            [codox "0.8.10"]
            [lein-clojuredocs "1.0.2"]

            ;; Static analysis
            [lein-typed "0.3.5"]
            ;; [jonase/eastwood "0.1.2"]
            [lein-bikeshed "0.2.0"]
            [lein-kibit "0.0.8"]]

  :dependencies [[org.clojars.gjahad/debug-repl "0.3.3"]
                 [difform "1.1.2"]

                 [spyscope "0.1.5"]
                 [org.clojure/tools.trace "0.7.8"]
                 [org.clojure/tools.namespace "0.2.9"]
                 [io.aviso/pretty "0.1.8"]
                 [im.chit/vinyasa "0.3.3"]

                 [slamhound "1.5.5"]
                 [criterium "0.4.3"]]

  :injections [(require 'spyscope.core)
               (require '[vinyasa.inject :as inject])
               (require 'io.aviso.repl)
               (inject/in ;; the default injected namespace is `.`

                ;; note that `:refer, :all and :exclude can be used
                [vinyasa.inject :refer [inject [in inject-in]]]

                ;; inject into clojure.core
                clojure.core
                [vinyasa.reflection .> .? .* .% .%> .& .>ns .>var]

                ;; inject into clojure.core with prefix
                clojure.core >
                [clojure.pprint pprint]
                [clojure.java.shell sh])]}}

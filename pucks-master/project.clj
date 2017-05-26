(defproject pucks "0.1.26"
  :description "An environment for experiments and education in artificial intelligence and artificial life."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "https://github.com/lspector/pucks"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [quil "2.4.0"]
                 [clojush "2.8.0"]]
  :plugins [[org.clojars.benfb/lein-gorilla "0.3.5"]]
  :main pucks.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  ;; the following should automatically take n% of the machine's RAM and also use the G1 garbage collector
  ;:jvm-opts ~(let [mem-to-use (long (* (.getTotalPhysicalMemorySize
  ;                                       (java.lang.management.ManagementFactory/getOperatingSystemMXBean))
  ;                                     0.5))]
  ;             [(str "-Xmx" mem-to-use)
  ;              (str "-Xms" mem-to-use)
  ;              ;"-XX:+UseG1GC"
  ;              ])
  )

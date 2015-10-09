==============
 kuromadoushi
==============

黒魔道士を描画するライブラリです。

Usage
=====

シンプルな 2 つの関数を提供します。

``kuromadoushi.core/render``, ``kuromadoushi.core/render*`` のふたつです。

.. sourcecode:: clojure

  (require '[kuromadoushi.core :as kuro])
  (kuro/render "01234567") ;; => 8 つの全角スペースが出力されるけど見えない…
  (kuro/render* "01234567") ;; => "[40m　[m[41m　[m[42m　[m[43m　[m[44m　[m[45m　[m[46m　[m[47m　[m"

.. image:: ./img/kuromadoushi.png

.. image:: http://clojars.org/kuromadoushi/latest-version.svg?style=svg
    :target: http://clojars.org/kuromadoushi

License
=======

The MIT License (MIT)

Copyright (c) 2015 Ayato Nishimura, http://ayalog.com/

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

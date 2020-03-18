---
# Feel free to add content and custom Front Matter to this file.
# To modify the layout, see https://jekyllrb.com/docs/themes/#overriding-theme-defaults

layout: default
---

# Лекции

* [Часть 1. Введение в Scala. Case классы и pattern matching](slides/day1.html) 24 января. [Версия для печати](slides/day1.html?print-pdf).
  * Видео: [Обзор курса и введение в Scala](https://www.youtube.com/watch?v=T-fIGEPSynM).
  * Видео: [Case классы и pattern matching](https://youtu.be/M5WeHhmawYQ).
* [Часть 2. Иммутабельность и базовые структуры данных. Работа со списками](slides/day2.html) 31 января. [Версия для печати](slides/day2.html?print-pdf).
  * Видео: [Работа со списками](https://youtu.be/1I1A5QUBy1k).
* [Часть 3. Vector. Ленивые вычисления. LazyList и View. Монады](slides/day3.html) 7 февраля. [Версия для печати](slides/day3.html?print-pdf).
  * Видео: [Vector. Ленивые вычисления. LazyList](https://youtu.be/BZ72l3UYQeo).
  * Видео: [Большое задание. View. Монады](https://youtu.be/Zye78QvxzIY).
* [Часть 4. Implicit значения и преобразования. Тайпклассы. Чтение и запись JSON в play-json](slides/day4.html) 14 февраля. [Версия для печати](slides/day4.html?print-pdf).
  * Видео: [Implicit значения. Тайпклассы. Моноиды](https://youtu.be/0Q2j6yZ0okQ).
  * Видео: [Применение тайпклассов на примере play-json](https://youtu.be/nEuVFosoxJE).
* [Часть 5. Базовые примитивы многопоточности](slides/day5.html) 21 февраля. [Версия для печати](slides/day5.html?print-pdf).
  * Видео: [Домашнее задание](https://youtu.be/l7ky4d0PuR4).
  * Видео: [Многопоточность и асинхронность в JVM](https://youtu.be/gNaHDBK1nrQ).
  * Видео: [Future и Promise](https://youtu.be/1G7oNfP-PZs).
* [Часть 6. IO-монада, ZIO и Cats Effects](io-monad.pdf). Рассказывает Илья Слободянюк. 28 февраля.
  * [Домашнее задание](slides/day6-task.html)
  * Видео: [Домашнее задание](https://youtu.be/r9qCfpsuqFg).
  * Видео: [IO монада, ZIO и Cats Effect](https://youtu.be/EIaqf4Jsy8U).
* [Часть 7. HTTP Протокол. Play Framework. Архитектура высоконагруженных приложений](slides/day7.html). 6 марта. [Версия для печати](slides/day7.html?print-pdf).
  * Видео: [Java NIO и HTTP](https://youtu.be/Cpb8Z0MNI7g).
  * Видео: [REST и Play Framework](https://youtu.be/vxFpEG8NYUg).
* [Часть 8. Акторы Akka, часть 1](slides/day8.html). 20 марта. [Версия для печати](slides/day8.html?print-pdf).
* Часть 9. Акторы Akka, часть 2. 27 марта.
* Часть 10. Akka Streams и реактивные потоки. 3 апреля.
* Часть 11. Event Sourcing и CQRS. Akka Persistence. 10 апреля.
* Часть 12. Akka-Http. Директивы и магниты. Поточный JSON. Условные кеш и условные запросы. 17 апреля.
* Подведение итогов. 24 апреля.

Внимание! Для распечатки слайдов или сохранения в PDF используейте ссылки "версии для печати" и браузер Chrome/Chromium.

[Playlist со всеми видео](https://www.youtube.com/playlist?list=PLr3MOSSJVvAFDW8sY3qbowgMa-eFplLcG)

# Семинары

1. Юнит тесты на Specs2 и ScalaCheck. 29 января. 
   * Демо проект [на github](https://github.com/maxcom/scala-course-2020/tree/gh-pages/code/seminar1).
2. Измеряем скорость операций над коллекциями при помощи JMH. 5 февраля. 
   * Стартовый проект [на github](https://github.com/maxcom/scala-course-2020/tree/gh-pages/code/seminar2).
3. Решаем задачи с использованием LazyList. 12 февраля. 
   * [Решето Эратосфена](https://ru.wikipedia.org/wiki/%D0%A0%D0%B5%D1%88%D0%B5%D1%82%D0%BE_%D0%AD%D1%80%D0%B0%D1%82%D0%BE%D1%81%D1%84%D0%B5%D0%BD%D0%B0).
   * [Задача о ходе коня](https://ru.wikipedia.org/wiki/%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%85%D0%BE%D0%B4%D0%B5_%D0%BA%D0%BE%D0%BD%D1%8F)
4. Практика по использованию play-json и обзор Circe. 19 февраля.
   * Circe. [Слайды](CircePr.pdf)
   * [Play JSON Derived Codecs](https://github.com/julienrf/play-json-derived-codecs)
5. Практика по использованию Future/Promise. 26 февраля.
   * Планировщик: [решение](https://gist.github.com/maxcom/fb991136b142eff29e24478a87538ccc).
6. Практика по реализации тайпклассов Cats. 4 марта.
   * Стартовый проект [на github](https://github.com/maxcom/scala-course-2020/tree/gh-pages/code/seminar-type-classes).
7. Play Framework: сессии, аутентификация и обработка ошибок. 11 марта.
   * Стартовый проект [на github](https://github.com/maxcom/scala-course-2020/tree/gh-pages/code/seminar-play-auth).
8. Работа с реляционными БД: scalikejdbc, slick и doobie. 18 марта.
   * Стартовый проект [на github](https://github.com/maxcom/scala-course-2020/tree/gh-pages/code/seminar_db).

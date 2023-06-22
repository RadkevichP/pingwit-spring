package pl.pingwit.pingwitdemospring.lec_38;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
@RestController
@RequestMapping("/hello")
public class HelloController {


    @GetMapping("/world")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/page")
    public String getPage() {
        return """
                <!DOCTYPE html>
                <html lang="ru">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Заголовок страницы</title>
                    <link rel="stylesheet" href="./styles/style.css">
                                
                    <meta property="og:title" content="Заголовок страницы в OG">
                    <meta property="og:description" content="Описание страницы в OG">
                    <meta property="og:image" content="https://example.com/image.jpg">
                    <meta property="og:url" content="https://example.com/">
                  </head>
                  <body>
                    <header>
                      <h1>Это мой сайт</h1>
                      <p>Он хороший</p>
                      <nav>
                        <ul>
                          <li><a href="index.html">Эта страница</a></li>
                          <li><a href="catalog.html">Другая страница</a></li>
                        </ul>
                      </nav>
                    </header>
                    <main>
                      <article>
                        <section>
                          <h2>Первая секция</h2>
                          <p>Она обо мне</p>
                          <img src="images/image.png" alt="Человек и пароход">
                          <p>Но может быть и о семантике, я пока не решил.</p>
                        </section>
                        <section>
                          <h2>Вторая секция</h2>
                          <p>Она тоже обо мне</p>
                        </section>
                        <section>
                          <h2>И третья</h2>
                          <p>Вы уже должны были начать догадываться.</p>
                        </section>
                      </article>
                    </main>
                    <footer>
                      <p>Сюда бы я вписал информацию об авторе и ссылки на другие сайты</p>
                    </footer>
                    <!-- сюда можно подключить jquery <script src="scripts/app.js" defer></script> -->
                  </body>
                </html>
                """;
    }

}


// GET ..../hello/world  ->

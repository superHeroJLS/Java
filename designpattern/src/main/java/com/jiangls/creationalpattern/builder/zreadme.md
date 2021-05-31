# 生成器模式
将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。<br/>
生成器模式（Builder）是使用多个“小型”工厂来最终创建出一个完整对象。
当我们使用Builder的时候，一般来说，是因为创建这个对象的步骤比较多，每个步骤都需要一个零部件，
且创建过程中可以灵活调用不同的步骤或组件，最终组合成一个完整的对象。
创建一个Builder：HtmlBuilder

# 使用情况（最佳实践）
由HtmlBuilder可见，使用Builder模式时，适用于创建的对象比较复杂，最好一步一步创建出“零件”，最后再装配起来
## case1： JavaMail的MimeMessage
JavaMail的MimeMessage就可以看作是一个Builder模式，只不过Builder和最终产品合二为一，都是MimeMessage：
```
    Multipart multipart = new MimeMultipart();
    // 添加text:
    BodyPart textpart = new MimeBodyPart();
    textpart.setContent(body, "text/html;charset=utf-8");
    multipart.addBodyPart(textpart);
    // 添加image:
    BodyPart imagepart = new MimeBodyPart();
    imagepart.setFileName(fileName);
    imagepart.setDataHandler(new DataHandler(new ByteArrayDataSource(input, "application/octet-stream")));
    multipart.addBodyPart(imagepart);
    
    // 这里的MimeMessage就可以看成Builder，实际上是Builder和产品结合了，既是Builder，也是产品
    MimeMessage message = new MimeMessage(session);
    // 设置发送方地址:
    message.setFrom(new InternetAddress("me@example.com"));
    // 设置接收方地址:
    message.setRecipient(Message.RecipientType.TO, new InternetAddress("xiaoming@somewhere.com"));
    // 设置邮件主题:
    message.setSubject("Hello", "UTF-8");
    // 设置邮件内容为multipart:
    message.setContent(multipart);
```
## case2: 链式调用
很多时候，我们可以简化Builder模式，以链式调用的方式来创建对象。例如，我们经常编写这样的代码：
```
    StringBuilder builder = new StringBuilder();
    builder.append(secure ? "https://" : "http://")
           .append("www.liaoxuefeng.com")
           .append("/")
           .append("?t=0");
    String url = builder.toString();
```



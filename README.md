# Spring bootサンプルアプリケーション: 共用施設利用申請・問い合わせアプリ
[https://github.com/saladlam/spring-noticeboard](https://github.com/saladlam/spring-noticeboard)

## 目的
このアプリケーションを作成した目的は、Spring frameworkを構成する、様々なコンポーネントの流れの理解を深めるため。またSpringBootを活用した各種機能の実装を通してWebアプリケーションのバックエンドの仕組みを理解する。

## 機能
- ユーザー登録・ログイン機能
- パスワードのエンコード化
- 管理者権限・ユーザー権限
- メールを使用した問い合わせ機能
- 検索機能
- CRUD機能
- 共通レイアウト

## 使われる主要なコンポーネント
- Spring Boot 2.1.X
- Spring MVC 5.1.X と thymeleaf 3.0.X
- Spring Security 5.1.X
- Spring JDBC 5.1.X
- Dozer 5.5.X
- GoogleCalendarAPI
- MYSQL5.7.X
- Heroku

## アプリ作成を通して解決したい課題
-前職で担当していた中規模マンションでは、住民が各施設を利用する場合に申込書を管理事務所へ直接提出しなければならない。しかし、管理人は清掃業務等で事務所を不在にしているケースが多くクレームが多く来る課題があった。そのため、本アプリでは紙媒体の申請を取りやめ各設備の利用申請をPC上で解決することを目的とし作成した。

## 使用例


## データベース
データはMYSQLに記憶する。スキーマとデータはアプリケーション起動時がインポートされる。

## 必要なもの
- Java SE Development Kit 8以降
- インタネット接続

## アカウント
| ユーザーネーム | パスワード | 権限 |
|:-------- |:------------ |:----------- |
| admin    | password1234 | ADMIN       |
| bob      | password1234 | USER        |
| lisa     | password1234 | USER        |
| mike     | password1234 | ADMIN       |
| tom      | password1234 | USER        |

##実装できなかった機能
-ページネーション
-AWSを使用したデプロイ

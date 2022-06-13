# Spring bootサンプルアプリケーション: 共用施設利用申請・問い合わせアプリ
[https://github.com/saladlam/spring-noticeboard](https://github.com/saladlam/spring-noticeboard)

## 目的
このアプリケーションを作成した目的は、Spring frameworkを構成する、いろいろなコンポーネントの流れを説明するため。

## 機能
- ログイン機能
- 管理者権限・ユーザー権限
- メールを使用した問い合わせ機能
- 検索機能
- CRUD機能

## 使われる主要なコンポーネント
- Spring Boot 2.1.X
- Spring MVC 5.1.X と thymeleaf 3.0.X
- Spring Security 5.1.X
- Spring JDBC 5.1.X
- Dozer 5.5.X
- GoogleCalendarAPI

## データベース
データはMYSQLに記憶する。スキーマとデータはアプリケーション起動時がインポートされる。

## 必要なもの
- Java SE Development Kit 8以降
- インタネット接続

## アカウント
| ユーザーネーム | パスワード | 権限 |
|:-------- |:-------- |:----------- |
| user1    | user1    | USER        |
| user2    | user2    | USER        |
| admin    | admin    | USER, ADMIN |

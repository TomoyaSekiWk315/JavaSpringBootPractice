# JavaSpringBootPractice

Spring Bootの演習プロジェクト集です。基本的なSpring BootアプリケーションからREST APIの実装、キャッシュ機能の利用まで段階的に学習できます。

## プロジェクト構成

このリポジトリには以下の3つのSpring Bootプロジェクトが含まれています。

### 1. spring1hello1
基本的なSpring Bootアプリケーションの最小構成プロジェクト。
- Spring Bootの起動と動作確認
- アプリケーションの基本設定

### 2. spring1hello2
RESTコントローラーを使用したHello Worldアプリケーション。
- `@RestController`の実装
- `@GetMapping`を使用したエンドポイントの定義
- 複数のエンドポイント（`/`, `/hello`, `/welcome`）の実装
- ポート番号のカスタマイズ（8081）

### 3. spring2item
REST APIを使用したアイテム管理システム。
- 完全なCRUD操作（作成・読み取り・更新・削除）の実装
- Controller、Service、Modelの階層構造
- Spring Cacheによるキャッシュ機能
- テストコードの実装（MockMvcを使用）

## 使用技術

### フレームワーク・ライブラリ
- **Spring Boot**: 3.5.7
- **Java**: 17
- **Maven**: ビルドツール

### Spring Boot Starter
- **spring-boot-starter-web**: REST APIの実装
- **spring-boot-starter-cache**: キャッシュ機能（spring2itemのみ）
- **spring-boot-starter-test**: テストフレームワーク

### テスト
- **JUnit 5**: ユニットテスト
- **MockMvc**: Web層のテスト
- **AssertJ**: アサーションライブラリ

## プロジェクト構造

```
spring2item/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/udemy/spring2item/
│   │   │       ├── Controller/      # RESTコントローラー
│   │   │       ├── model/           # エンティティモデル
│   │   │       ├── service/         # ビジネスロジック
│   │   │       └── Spring2itemApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/udemy/spring2item/
│               └── Controller/      # コントローラーテスト
```

## 機能概要

### spring1hello2
- `GET /`: "アクセス成功です。"を返す
- `GET /hello`: "hello world."を返す
- `GET /welcome`: "Spring Welcome."を返す

### spring2item
- `GET /items`: すべてのアイテムを取得（キャッシュあり）
- `GET /items/{itemId}`: 特定のアイテムを取得（キャッシュあり）
- `POST /items`: 新しいアイテムを追加
- `PUT /items/{itemId}`: アイテムを更新
- `DELETE /items/{itemId}`: アイテムを削除

## 実行方法

### 前提条件
- Java 17以上
- Maven 3.6以上

### ビルド・実行
各プロジェクトのディレクトリに移動して実行します。

```bash
# プロジェクトディレクトリに移動
cd spring1hello1

# Mavenでビルド
mvn clean install

# Spring Bootアプリケーションを起動
mvn spring-boot:run
```

### 実行ポート
- **spring1hello1**: デフォルト（8080）
- **spring1hello2**: 8081
- **spring2item**: デフォルト（8080）

## テストの実行

```bash
# テストを実行
mvn test

# 特定のプロジェクトのテストを実行
cd spring2item
mvn test
```

## 学習内容

このプロジェクトを通じて以下の技術を学習できます：

1. **Spring Bootの基本**
   - プロジェクトの作成と構成
   - アプリケーションの起動方法

2. **REST APIの実装**
   - `@RestController`の使用
   - HTTPメソッドのマッピング（GET、POST、PUT、DELETE）
   - リクエスト・レスポンスのハンドリング

3. **Spring Frameworkの機能**
   - 依存性注入（`@Autowired`）
   - サービスの実装（`@Service`）
   - キャッシュ機能（`@Cacheable`、`@CacheEvict`）

4. **テスト**
   - Spring Bootテストの書き方
   - MockMvcを使ったWeb層のテスト
   - JSONのシリアライズ・デシリアライズ

## ライセンス

このプロジェクトは演習用のプロジェクトです。

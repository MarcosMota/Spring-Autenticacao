var gulp = require('gulp');
var jshint = require('gulp-jshint');
var uglify = require('gulp-uglify');
var concat = require('gulp-concat');
var rename = require('gulp-rename');

var fonts = ["../bower_components/bootstrap/dist/fonts"]
var css = ["../bower_components/bootstrap/dist/css"];
var js = ["../bower_components/echarts/dist/echarts.js",
    "../bower_components/bootstrap/dist/js/bootstrap.js"];

var distJs = "../AutenticacaoSpring/src/main/webapp/resources/js";
var distCss = "../AutenticacaoSpring/src/main/webapp/resources/css";
var distFonts = "../AutenticacaoSpring/src/main/webapp/resources/fonts/**.*";


gulp.task('js', function () {

// Carregamos os arquivos novamente
// E rodamos uma tarefa para concatenação
// Renomeamos o arquivo que sera minificado e logo depois o minificamos com o `uglify`
// E pra terminar usamos o `gulp.dest` para colocar os arquivos concatenados e minificados na pasta build/
    gulp.src(js,
            {base: '../bower_components/'})
            .pipe(rename('app.min.js'))
            .pipe(uglify())
            .pipe(gulp.dest(distJs));
});
gulp.task('css', function () {
    gulp.src(css)
            .pipe(rename('app.min.css'))
            .pipe(uglify())
            .pipe(gulp.dest(distCss));
});
gulp.task('font', function () {
    gulp.src(fonts)
            .pipe(gulp.dest(distFonts));
});
gulp.task('default', function () {
    gulp.run('js', 'css','font');
});
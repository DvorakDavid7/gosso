function Login() {

    const githubOAuthUrl = "https://github.com/login/oauth/authorize?client_id=caa237420f23048440c7"

    return (
        <a href={githubOAuthUrl}>
            login via github
        </a>
    )
}

export default Login

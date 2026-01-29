Feature: Authentification

  Scenario: Connexion avec des identifiants valides à l'application de RH
    Given l'utilisateur est sur la page de connexion
    When il saisit le login "Admin" et le mot de passe "admin123"
    When il renseigne les champs suivants il pourra se connecter
    | login | Admin     |
    | mot de passe | admin123 |
    Then il est redirigé vers la page d'accueil

